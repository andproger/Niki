package com.niki.data.repository;

import com.niki.data.cache.database.datastores.BusColorDataStore;
import com.niki.data.cache.database.datastores.BusModelDataStore;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.gateways.repositories.BusColorRepository;
import com.niki.domain.gateways.repositories.BusModelRepository;

import java.util.List;

public class BusModelRepositorySql implements BusModelRepository {

    private final BusModelDataStore dataStore;

    public BusModelRepositorySql(BusModelDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<BusModel> get() {
        return dataStore.getAll();
    }

    @Override
    public BusModel get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<BusModel> buses) {
        dataStore.save(buses);
    }
}
