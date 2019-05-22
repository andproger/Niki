package com.niki.data.repository;

import com.niki.data.cache.database.datastores.ManufacturerDataStore;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.gateways.repositories.ManufacturerRepository;

import java.util.List;

public class ManufacturerRepositorySql implements ManufacturerRepository {

    private final ManufacturerDataStore dataStore;

    public ManufacturerRepositorySql(ManufacturerDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return dataStore.getAll();
    }

    @Override
    public void saveManufacturers(List<Manufacturer> manufacturers) {
        dataStore.save(manufacturers);
    }
}
