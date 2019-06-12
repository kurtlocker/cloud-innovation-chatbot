package com.kraken.persistence.mongo;

import com.kraken.persistence.mongo.repository.DeliMenusRepository;
import com.kraken.persistence.mongo.repository.OfficesRepository;
import com.kraken.persistence.mongo.repository.WarehousesRepository;
import com.kraken.services.deli.data.Menu;
import com.kraken.services.office.data.Office;
import com.kraken.services.warehouse.data.Warehouse;

import org.springframework.beans.factory.annotation.Autowired;

public class MongoWriter {

    @Autowired
    private static WarehousesRepository warehousesRepo;

    @Autowired
    private static OfficesRepository officesRepo;

    @Autowired
    private static DeliMenusRepository deliRepo;

    public static void saveWarehouse(Warehouse warehouse) {
        warehousesRepo.save(warehouse);
    }

    public static void saveOffice(Office office) {
        officesRepo.save(office);
    }

    public static void saveMenu(Menu menu) {
        deliRepo.save(menu);
    }

}