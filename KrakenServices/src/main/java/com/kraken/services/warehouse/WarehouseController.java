package com.kraken.services.warehouse;

import java.util.List;

import com.kraken.services.warehouse.data.Warehouse;
import com.kraken.services.warehouse.util.WarehouseUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @RequestMapping("/warehouses")
    public List<Warehouse> getWarehouses(@RequestParam(value="latitude") String latitude, @RequestParam(value="longitude") String longitude) {
        return WarehouseUtil.getWarehousesByGeoLocation(latitude, longitude);
    }

    @RequestMapping("/warehouse")
    public Warehouse warehouse(@RequestParam(value="warehouseNumber") int warehouseNumber) {
        return WarehouseUtil.getWarehouseByNumber(warehouseNumber);
    }
}
