package com.kraken.services.warehouse.scrape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kraken.services.warehouse.data.GeoLocation;
import com.kraken.services.warehouse.data.Warehouse;

import org.springframework.web.client.RestTemplate;


public class WarehouseScraper {
    private static final String END_POINT = "https://www.costco.com/AjaxWarehouseBrowseLookupView";

    private List<Warehouse> warehouses;
    private Warehouse warehouse;
    private int numResults;
    private GeoLocation location;

    public WarehouseScraper(GeoLocation location, int numResults) {
        RestTemplate restTemplate = new RestTemplate();
        warehouses = Arrays.asList(restTemplate.getForObject(END_POINT, Warehouse[].class));
    }
}