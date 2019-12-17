package com.niki.data.repository;

import com.niki.data.cache.database.datastores.FlightDataStore;
import com.niki.data.cache.database.datastores.RouteDataStore;
import com.niki.domain.entities.Flight;
import com.niki.domain.entities.Route;
import com.niki.domain.gateways.repositories.FlightRepository;
import com.niki.domain.gateways.repositories.RouteRepository;

import java.util.List;

public class FlightRepositorySql implements FlightRepository {

    private final FlightDataStore dataStore;

    public FlightRepositorySql(FlightDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Flight> get() {
        return dataStore.getAll();
    }

    @Override
    public Flight get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<Flight> items) {
        dataStore.save(items);
    }
}
