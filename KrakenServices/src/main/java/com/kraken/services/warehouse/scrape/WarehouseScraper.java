package com.kraken.services.warehouse.scrape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kraken.services.warehouse.data.Warehouse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class WarehouseScraper {
    private static final String END_POINT = "https://www.costco.com/AjaxWarehouseBrowseLookupView";

    private static RestTemplate restTemplate;
    private List<Warehouse> warehouses;
    private UriComponentsBuilder endpoint;

    {
        restTemplate = new RestTemplate();
        endpoint = UriComponentsBuilder.fromUriString(END_POINT)
                    .queryParam("langId", "-1")
                    .queryParam("storeId", "10301")
                    .queryParam("hasGas", false)
                    .queryParam("hasTires", false)
                    .queryParam("hasFood", false)
                    .queryParam("hasHearing", false)
                    .queryParam("hasPharmacy", false)
                    .queryParam("hasOptical", false)
                    .queryParam("hasBusiness", false)
                    .queryParam("hasPhotoCenter", false)
                    .queryParam("tiresCheckout", 0)
                    .queryParam("isTransferWarehouse", false)
                    .queryParam("populateWarehouseDetails", true)
                    .queryParam("warehousePickupCheckout", false);        
    }

    public WarehouseScraper(String latitude, String longitude, int numResults) {
        endpoint.queryParam("numOfWarehouses", numResults)
        .queryParam("latitude", latitude)
        .queryParam("longitude", longitude);
    }

    public WarehouseScraper(int warehouseNumber) {
        endpoint.queryParam("warehouseNumber", warehouseNumber);
    }

    public List<Warehouse> getWarehouses() {
        if (CollectionUtils.isEmpty(warehouses)) {
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
            //Add the Jackson Message converter
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

            // Note: here we are making this converter to process any kind of response, 
            // not only application/*json, which is the default behaviour
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
            messageConverters.add(converter);  
            restTemplate.setMessageConverters(messageConverters); 
            warehouses = Arrays.asList(restTemplate.getForObject(endpoint.toUriString(), Warehouse[].class));
        }
        return warehouses;
    }
}