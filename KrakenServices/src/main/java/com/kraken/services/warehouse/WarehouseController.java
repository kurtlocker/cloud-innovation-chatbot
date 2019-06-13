package com.kraken.services.warehouse;

import java.util.List;

import com.kraken.persistence.mongo.repository.WarehouseRepository;
import com.kraken.services.warehouse.data.Warehouse;
import com.kraken.services.warehouse.scrape.WarehouseScraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {
    
    @Autowired
    private WarehouseRepository warehouseRepo;

    // @RequestMapping("/warehouses")
    // public List<Warehouse> getWarehouses(@RequestParam(value="latitude") String latitude, 
    //                                      @RequestParam(value="longitude") String longitude,
    //                                      @RequestParam(value="numResults", defaultValue = "5") int numResults) {
    //     return WarehouseUtil.getWarehousesByGeoLocation(latitude, longitude, numResults);
    // }

    @RequestMapping("/warehouse")
    public Warehouse getWarehouse(@RequestParam(value="warehouseNumber") int warehouseNumber) {
        Warehouse warehouse = warehouseRepo.findByStlocID(Long.valueOf(warehouseNumber));
        if (warehouse == null) {
            WarehouseScraper scraper = new WarehouseScraper(110);
            List<Warehouse> warehouses = scraper.getWarehouses();
            warehouse = warehouses.get(0);
        }
        return warehouse;
        // return warehouseUtil.getWarehouseByNumber(warehouseNumber);
    }
}
