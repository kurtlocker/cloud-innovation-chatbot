package com.costco.kraken.routeengine.model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.costco.kraken.routeengine.model.GeoJsonPath;

/**
 * 
 * Representation of the graph using an adjacencyList. The graph can be initalized from a
 * List of jsonPaths that is stored in a geoJSON format.
 * 
 * This graph by default will be a non-directed graph as it is supposed to represent an
 * office space which should be non-directed
 * 
 * 
 * Future release may change this to be a directed graph to take into account the cost difference
 * between going up and down stairs [down stairs should be 1 direction with less weight than going up]
 * 
 * @author wsoetanto
 *
 */

public class Graph
{   
    private final Map<Node, List<Node>> adjacencyList;
    
    private final Map<String, Point> locationList;

	public Graph() {
        this.adjacencyList = new HashMap<>();
        this.locationList = new HashMap<>();
    }
    
    /**
     * Construct the graph from a jsonPath array.
     * By default we are assuming the graph is a non-directed graph
     * 
     * @param jsonPaths
     */
    public Graph(GeoJsonPath[] jsonPaths) {
    	
    	this.adjacencyList = new HashMap<>();
    	this.locationList = new HashMap<>();
    	
    	this.initPaths(jsonPaths);
    	
    }
    
    /**
     *  
     * @param officeBlueprint
     */
    public Graph(OfficeBlueprint officeBlueprint) {
    	
    	this.adjacencyList = new HashMap<>();
    	this.locationList = new HashMap<>();
    	
    	this.initPaths(officeBlueprint.getPath());
    	this.initLocation(officeBlueprint.getLocation());
    }
    
    
    private void initPaths(GeoJsonPath[] jsonPaths) {
    	for(int x=0; x < jsonPaths.length; x++) {
    		GeoJsonPath path = jsonPaths[x];
    		List<Point> pathCoordinates = path.getCoordinates();
    		
    		for(int y = 0; y<pathCoordinates.size() - 1; y++) {
    			this.addEdge(pathCoordinates.get(y), pathCoordinates.get(y+1));
    			this.addEdge(pathCoordinates.get(y+1), pathCoordinates.get(y));
    		}
    	}	
    }
    
    private void initLocation(Location[] jsonLocations) {
    	for(int x=0; x < jsonLocations.length; x++) {
    		Location loc = jsonLocations[x];
    		locationList.put(loc.getLocationName(), loc.getCoordinates());
    	}	
    }
    
    /**
     * Private method to add a new edge to the graph from 2 point
     * Will call another function which will accept Node
     * @param source
     * @param destination
     */
    private void addEdge(Point source, Point destination) {
    	this.addEdge(new Node(source), new Node(destination));
    }

    /**
     * Private method to add a new edge from 2 different node object
     * @param source
     * @param destination
     */
    private void addEdge(Node source, Node destination) {
    	
    	if(this.adjacencyList.containsKey(source)) {
    		List<Node> neighborList = this.adjacencyList.get(source);
    		neighborList.add(destination);
    		this.adjacencyList.put(source, neighborList);
    		
    	}
    	else {
    		ArrayList<Node> neighborList = new ArrayList<>();
    		neighborList.add(destination);
    		this.adjacencyList.put(source, neighborList);
    	}
    	
    }
    
    /**
     * Method to get the neighbors of a given node
     * will return an empty list if the node is not found
     * @param node
     * @return
     */
    public List<Node> getNeighbors(Node node) {

    	if(this.adjacencyList.containsKey(node)) {
    		return this.adjacencyList.get(node);
    	}
    	else
    		return new ArrayList<Node>();
    }
    
    public Point getLocation(String locationName) {
    	
    	if(this.locationList.containsKey(locationName))
    		return this.locationList.get(locationName);
    	return null;
    }
}
