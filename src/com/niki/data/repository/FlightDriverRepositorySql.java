package com.niki.data.repository;

import com.niki.data.cache.database.datastores.FlightDriverDataStore;
import com.niki.domain.entities.FlightDriver;
import com.niki.domain.gateways.repositories.FlightDriverRepository;

import java.util.List;

public class FlightDriverRepositorySql implements FlightDriverRepository {

    private final FlightDriverDataStore dataStore;

    public FlightDriverRepositorySql(FlightDriverDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<FlightDriver> get() {
        return dataStore.getAll();
    }

    @Override
    public List<FlightDriver> getByFlight(int id) {
        return dataStore.getByFlight(id);
    }

    @Override
    public FlightDriver get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<FlightDriver> items) {
        dataStore.save(items);
    }
}
