package com.costco.kraken.routeengine.model;

import java.awt.Point;
import java.util.Objects;

/**
 * Model representation a node within our routing engine graph
 * This node will contain the geoSpatial coordinate along with some variables
 * that is used to calculate the route via A* 
 * 
 * @author wsoetanto
 *
 */
public class Node implements Comparable<Node> {

	private Point coordinate;

    private double gCost;

    private double fCost = 0;

    public Node parent;

    public Node() {
        this.coordinate = new Point(0,0);
        this.fCost = 0.0;
        this.gCost = 0.0;
    }
    
    public Node(Point p){
        this.coordinate =  p;
        this.fCost = 0.0;
        this.gCost = 0.0;
    }

    public Node(int x, int y){
        this.coordinate =  new Point(x,y);
        this.fCost = 0.0;
        this.gCost = 0.0;
    }

    public Point getCoordinate() {
        return this.coordinate;
    }

    public String toString() {
        return "["+this.coordinate.getX()+","+this.coordinate.getY()+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getCoordinate().equals(node.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinate());
    }

    /**
     * Custom comparator that is used to rank the node within
     * the priority queue for the route engine
     * 
     * @param n
     * @return
     */
    public int compareTo(Node n) {
        if(this.fCost > n.fCost)
            return 1;
        else if(this.fCost < n.fCost)
            return -1;
        else
            return 0;
    }

    public void setGCost(double gCost) {
        this.gCost = gCost;
    }

    public double getGCost(){
        return this.gCost;
    }

    public void setFCost(double fCost) {
        this.fCost = fCost;
    }

    public double getfCost(){
        return this.fCost;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

}
