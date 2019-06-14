package com.costco.kraken.controller;

import java.awt.Point;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.costco.kraken.api.DirectionApi;
import com.costco.kraken.model.Directions;
import com.costco.kraken.routeengine.MapEngine;
import com.costco.kraken.routeengine.RouteEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.applicationinsights.TelemetryClient;

import io.swagger.annotations.ApiParam;

@Controller
public class DirectionApiController implements DirectionApi {
	
	private static final Logger logger = LogManager.getLogger(DirectionApiController.class);
	
    @org.springframework.beans.factory.annotation.Autowired
    public DirectionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    }
    
    public ResponseEntity<Directions> calculateRoute(
    			@ApiParam(value = "", required = false) @Valid @RequestParam(value = "startLocName", required = false) String start,
    			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "endLocName", required = true) String destination){
    	
    	//telemetryClient.trackEvent("Starting to calculate route from "+start +" to "+ destination);
    	
    	RouteEngine routeEngine =  new RouteEngine();
    	List<Point> path = routeEngine.calculatePath(start, destination);
    	//System.out.println("Path From "+start+" to "+ destination);
    	//System.out.println(path);
    	
    	String mapURI = "";
    	if(path!=null && !path.isEmpty()) {
    		try {
    			mapURI = MapEngine.generateMap(path);
    		}
    		catch(Exception e) {
    			logger.error("Error Generating and uploading map", e);
    			mapURI=e.getMessage();
    			//telemetryClient.trackEvent("Error generating map image" + e.getMessage());
    		}
    	}
    	Directions direction = new Directions();
    	direction.setNavigationPath(path);
    	direction.setMapURI(mapURI);
    	
    	//telemetryClient.trackEvent("Finish Calulating route");
    	
    	return new ResponseEntity<Directions> (direction, HttpStatus.OK);
    }
	
}
