// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

// index.js is used to setup and configure your bot

// Import required pckages
const path = require('path');
const restify = require('restify');

// Import required bot services. See https://aka.ms/bot-services to learn more about the different parts of a bot.
const { BotFrameworkAdapter, MemoryStorage, ConversationState, UserState } = require('botbuilder');

// This bot's main dialog.
const { DialogAndWelcomeBot } = require('./bots/dialogAndWelcomeBot');
const { MainDialog } = require('./dialogs/mainDialog');

// Note: Ensure you have a .env file and include LuisAppId, LuisAPIKey and LuisAPIHostName.
const ENV_FILE = path.join(__dirname, '.env');
require('dotenv').config({ path: ENV_FILE });

// Create adapter.
// See https://aka.ms/about-bot-adapter to learn more about adapters.
const adapter = new BotFrameworkAdapter({
    appId: process.env.MicrosoftAppId,
    appPassword: process.env.MicrosoftAppPassword,
    channelService: process.env.ChannelService,
    openIdMetadata: process.env.BotOpenIdMetadata
});

// Catch-all for errors.
adapter.onTurnError = async (context, error) => {
    // This check writes out errors to console log
    // NOTE: In production environment, you should consider logging this to Azure
    //       application insights.
    console.error(`\n [onTurnError]: ${ error }`);
    // Send a message to the user
    await context.sendActivity(`Oops. Something went wrong!`);
    // Clear out state
    await conversationState.delete(context);
};

// Define a state store for your bot. See https://aka.ms/about-bot-state to learn more about using MemoryStorage.
// A bot requires a state store to persist the dialog and user state between messages.
let conversationState, userState;

// For local development, in-memory storage is used.
// CAUTION: The Memory Storage used here is for local bot debugging only. When the bot
// is restarted, anything stored in memory will be gone.
const memoryStorage = new MemoryStorage();
conversationState = new ConversationState(memoryStorage);
userState = new UserState(memoryStorage);

// Pass in a logger to the bot. For this sample, the logger is the console, but alternatives such as Application Insights and Event Hub exist for storing the logs of the bot.
const logger = console;

// Create the main dialog.
const dialog = new MainDialog(logger);
const bot = new DialogAndWelcomeBot(conversationState, userState, dialog, logger);

// Create HTTP server
let server = restify.createServer();
server.listen(process.env.port || process.env.PORT || 3978, function() {
    console.log(`\n${ server.name } listening to ${ server.url }`);
    console.log(`\nGet Bot Framework Emulator: https://aka.ms/botframework-emulator`);
});



// Listen for incoming activities and route them to your bot main dialog.
server.post('/api/messages', (req, res) => {
    // Route received a request to adapter for processing

    function parseRequest(req) {
        return new Promise((resolve, reject) => {
            function returnActivity(activity) {
                if (typeof activity !== 'object') {
                    throw new Error(`BotFrameworkAdapter.parseRequest(): invalid request body.`);
                }
                if (typeof activity.type !== 'string') {
                    throw new Error(`BotFrameworkAdapter.parseRequest(): missing activity type.`);
                }
                if (typeof activity.timestamp === 'string') {
                    activity.timestamp = new Date(activity.timestamp);
                }
                if (typeof activity.localTimestamp === 'string') {
                    activity.localTimestamp = new Date(activity.localTimestamp);
                }
                if (typeof activity.expiration === 'string') {
                    activity.expiration = new Date(activity.expiration);
                }
                resolve(activity);
            }
            if (req.body) {
                try {
                    returnActivity(req.body);
                }
                catch (err) {
                    reject(err);
                }
            }
            else {
                let requestData = '';
                req.on('data', (chunk) => {
                    requestData += chunk;
                });
                req.on('end', () => {
                    try {
                        req.body = JSON.parse(requestData);
                        returnActivity(req.body);
                    }
                    catch (err) {
                        reject(err);
                    }
                });
            }
        });
    }

    adapter.processActivity = async function(req, res, logic) {
        let body;
        let status;
        try {
            // Parse body of request
            status = 400;
            const request = await parseRequest(req);
            // Authenticate the incoming request
            status = 401;
            const authHeader = req.headers.authorization || req.headers.Authorization || '';
            //await this.authenticateRequest(request, authHeader);
            // Process received activity
            status = 500;
            const context = this.createContext(request);
            await this.runMiddleware(context, logic);
            // Retrieve cached invoke response.
            // if (request.type === botbuilder_core_1.ActivityTypes.Invoke) {
            //     const invokeResponse = context.turnState.get(INVOKE_RESPONSE_KEY);
            //     if (invokeResponse && invokeResponse.value) {
            //         const value = invokeResponse.value;
            //         status = value.status;
            //         body = value.body;
            //     }
            //     else {
            //         status = 501;
            //     }
            // }
            status = 200;
        }
        catch (err) {
            body = err.toString();
        }
        // Return status 
        res.status(status);
        if (body) {
            res.send(body);
        }
        res.end();
        // Check for an error
        if (status >= 400) {
            console.warn(`BotFrameworkAdapter.processActivity(): ${status} ERROR - ${body.toString()}`);
            throw new Error(body.toString());
        }
    }

    adapter.authenticateRequest = async function(){

    };

    adapter.processActivity(req, res, async (turnContext) => {
        // route to bot activity handler.
        await bot.run(turnContext);
    });
});
