package com.costco.kraken.routeengine.model;

import java.awt.Point;
import java.util.List;

public class GeoJsonPath {
		
	private String name;
	
	private List<Point> coordinates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Point> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Point> coordinates) {
		this.coordinates = coordinates;
	}	

}
