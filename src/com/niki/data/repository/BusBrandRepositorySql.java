package com.niki.data.repository;

import com.niki.data.cache.database.datastores.BusBrandDataStore;
import com.niki.data.cache.database.datastores.BusModelDataStore;
import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusModel;
import com.niki.domain.gateways.repositories.BusBrandRepository;
import com.niki.domain.gateways.repositories.BusModelRepository;

import java.util.List;

public class BusBrandRepositorySql implements BusBrandRepository {

    private final BusBrandDataStore dataStore;

    public BusBrandRepositorySql(BusBrandDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<BusBrand> get() {
        return dataStore.getAll();
    }

    @Override
    public BusBrand get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<BusBrand> items) {
        dataStore.save(items);
    }
}
