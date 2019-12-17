package com.niki.data.repository;

import com.niki.data.cache.database.datastores.DriverDataStore;
import com.niki.domain.entities.Driver;
import com.niki.domain.gateways.repositories.DriverRepository;

import java.util.List;

public class DriverRepositorySql implements DriverRepository {

    private final DriverDataStore dataStore;

    public DriverRepositorySql(DriverDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Driver> get() {
        return dataStore.getAll();
    }

    @Override
    public Driver get(int userId) {
        return dataStore.getItem(userId);
    }

    @Override
    public void save(List<Driver> items) {
        dataStore.save(items);
    }
}
