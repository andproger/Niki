package com.niki.data.repository;

import com.niki.data.cache.datastores.ManufacturerDataStore;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.gateways.repositories.ManufacturerRepository;

import java.util.ArrayList;

public class ManufacturerRepositorySql implements ManufacturerRepository {

    private final ManufacturerDataStore dataStore;

    public ManufacturerRepositorySql(ManufacturerDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<Manufacturer> getManufacturers() {
        return dataStore.getAll();
    }

    @Override
    public void saveManufacturers(ArrayList<Manufacturer> manufacturers) {
        dataStore.save(manufacturers);
    }
}
