package com.niki.data.repository;

import com.niki.data.cache.database.datastores.RouteDataStore;
import com.niki.domain.entities.Route;
import com.niki.domain.gateways.repositories.RouteRepository;

import java.util.List;

public class RouteRepositorySql implements RouteRepository {

    private final RouteDataStore dataStore;

    public RouteRepositorySql(RouteDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Route> get() {
        return dataStore.getAll();
    }

    @Override
    public Route get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<Route> items) {
        dataStore.save(items);
    }
}
