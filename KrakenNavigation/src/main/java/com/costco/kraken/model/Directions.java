package com.costco.kraken.model;

import java.awt.Point;
import java.util.List;

import com.costco.kraken.routeengine.model.Location;
import com.costco.kraken.routeengine.model.Node;

public class Directions {
	
	private List<Point> navigationPath;
	
	private String mapURI;

	public String getMapURI() {
		return mapURI;
	}

	public void setMapURI(String mapURI) {
		this.mapURI = mapURI;
	}

	public List<Point> getNavigationPath() {
		return navigationPath;
	}

	public void setNavigationPath(List<Point> navigationPath) {
		this.navigationPath = navigationPath;
	}
	
}
