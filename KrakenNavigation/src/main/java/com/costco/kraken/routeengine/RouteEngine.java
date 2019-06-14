package com.costco.kraken.routeengine;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.costco.kraken.routeengine.model.Graph;
import com.costco.kraken.routeengine.model.Node;
import com.costco.kraken.routeengine.model.OfficeBlueprint;
import com.google.gson.Gson;

/**
 * 
 * Route engine class that will be used to calculate a path from point A to point B
 * Internally this will use an A* which will be good enough in terms of calculating 
 * a path but not necessarily the shortest path possible
 * 
 * @author wsoetanto
 *
 */
public class RouteEngine {
	
	private static final Logger logger = LogManager.getLogger(RouteEngine.class);
	
	private Graph graph;
	
	private PriorityQueue<Node> queue;
	
	private Set<Node> explored;
	
	private Node defaultStartPoint;
	
	public RouteEngine() {
		try {
			
			Resource defaultTopologyJson = new ClassPathResource("data/graph.json");
			
	        BufferedReader buffRead = new BufferedReader(new InputStreamReader(defaultTopologyJson.getInputStream()));
	        Gson gson = new Gson();
	        
	        OfficeBlueprint jsonTopo = gson.fromJson(buffRead, OfficeBlueprint.class);
	        
	        this.defaultStartPoint = new Node(jsonTopo.getDefaultStart());
	        this.graph = new Graph(jsonTopo);
	        
		}
		catch (Exception e) {
			logger.error("Error calculating route", e);
		}
		
	}
	
	
	public RouteEngine(Graph graph) {
		this.graph = graph;
	}
	
	public List<Point> calculatePath(String sourceLocName, String destLocName) {
		
		Point startPoint = this.graph.getLocation(sourceLocName);
		Point destPoint = this.graph.getLocation(destLocName);
		
		if(null != destPoint) {
			return calculatePath(startPoint, destPoint);
		}
		return null;	
	}
	
	/**
	 * 
	 * Function used to calculate the path from source
	 * to the goal.
	 * 
	 * @param source
	 * @param goal
	 * @return
	 */
	public List<Point> calculatePath(Point source,Point destination) {
		queue = new PriorityQueue<>(20);
        explored = new HashSet<>();
        boolean found = false;

        Node start = new Node(source);
        Node goal = new Node(destination);
        
        if(null == source)
        	start = this.defaultStartPoint;
        
        start.setGCost(0);
        start.setFCost(calculateDistance(start,goal));
        queue.add(start);


        while(!queue.isEmpty() && !found) {
            Node current = queue.poll();
            explored.add(current);

            if(current.equals(goal))
                found = true;

            for(Node neighborNode: this.graph.getNeighbors(current)) {
                double cost = calculateDistance(current, neighborNode);
                double temp_g_scores = current.getGCost() + cost;
                double temp_f_scores = temp_g_scores + calculateDistance(neighborNode, goal);

                if(explored.contains(neighborNode) && (temp_f_scores > neighborNode.getfCost())) {
                    continue;
                }
                else if(!queue.contains(neighborNode)|| temp_f_scores < neighborNode.getfCost()) {
                    neighborNode.parent = current;
                    neighborNode.setGCost(temp_g_scores);
                    neighborNode.setFCost(temp_f_scores);
                    if(queue.contains(neighborNode))
                        queue.remove(neighborNode);
                    queue.add(neighborNode);
                }
            }
        }

        if(found) {
            List<Point> path =  new ArrayList<>();
            Node current = getExploredNode(goal);
            while(null != current.getParent()) {
                path.add(current.getCoordinate());
                current = current.getParent();
            }
            path.add(current.getCoordinate());
            Collections.reverse(path);
            return path;
        }
        
        return null;
	}
	
	private static List<Node> compressPath() {
		return null;
	}
	
	private static double calculateDistance(Node source, Node destination) {
        return Math.abs(source.getCoordinate().getX() - destination.getCoordinate().getX())
                + Math.abs(source.getCoordinate().getY() - destination.getCoordinate().getY());
    }
	
	 private Node getExploredNode(Node node) {
	        for(Node n: this.explored) {
	           if(node.equals(n))
	               return n;
	        }
	        return null;
	    }

}
