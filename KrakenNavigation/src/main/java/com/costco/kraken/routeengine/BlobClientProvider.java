package com.costco.kraken.routeengine;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

/**
 * Manages the storage blob client
 */
public class BlobClientProvider {
	
	private static AzureProperties properties;

    /**
     * Validates the connection string and returns the storage blob client.
     * The connection string must be in the Azure connection string format.
     *
     * @return The newly created CloudBlobClient object
     *
     * @throws RuntimeException
     * @throws IOException
     * @throws URISyntaxException
     * @throws IllegalArgumentException
     * @throws InvalidKeyException
     */
    public static CloudBlobClient getBlobClientReference() throws RuntimeException, IOException, IllegalArgumentException, URISyntaxException, InvalidKeyException {


    	properties = new AzureProperties();
    	
        CloudStorageAccount storageAccount;
        try {
            storageAccount = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=costcocraig4b3e8;AccountKey=WqeP0nzhoL3XYNlJUZbYlYATPyQoE96m1T5Aw/WsRFFzXZw01COPUFeP6K/e19LaJV9tbUR17ASklr/0CPpfZQ==;EndpointSuffix=core.windows.net");
        }
        catch (IllegalArgumentException|URISyntaxException e) {
            System.out.println("\nConnection string specifies an invalid URI.");
            System.out.println("Please confirm the connection string is in the Azure connection string format.");
            throw e;
        }
        catch (InvalidKeyException e) {
            System.out.println("\nConnection string specifies an invalid key.");
            System.out.println("Please confirm the AccountName and AccountKey in the connection string are valid.");
            throw e;
        }

        return storageAccount.createCloudBlobClient();
    }

}