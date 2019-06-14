package com.costco.kraken.routeengine.model;

import java.awt.Point;

public class OfficeBlueprint {
	
	private Point defaultStart;
	
	private Location[] location;
	
	private GeoJsonPath[] path;
	
	public Point getDefaultStart() {
		return defaultStart;
	}

	public void setDefaultStart(Point defaultStart) {
		this.defaultStart = defaultStart;
	}

	public Location[] getLocation() {
		return location;
	}

	public void setLocation(Location[] location) {
		this.location = location;
	}


	public GeoJsonPath[] getPath() {
		return path;
	}

	public void setPath(GeoJsonPath[] path) {
		this.path = path;
	}
	
}
