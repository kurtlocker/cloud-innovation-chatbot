package com.kraken.persistence.mongo.repository;

import com.kraken.services.warehouse.data.Warehouse;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehousesRepository extends MongoRepository<Warehouse, String> {
    
    public Warehouse findByStlocID(long stlocID);
    public Warehouse findByLocationName(String locationName);
}
