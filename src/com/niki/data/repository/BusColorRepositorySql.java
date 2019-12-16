package com.niki.data.repository;

import com.niki.data.cache.database.datastores.BusColorDataStore;
import com.niki.data.cache.database.datastores.BusDataStore;
import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusColor;
import com.niki.domain.gateways.repositories.BusColorRepository;
import com.niki.domain.gateways.repositories.BusRepository;

import java.util.List;

public class BusColorRepositorySql implements BusColorRepository {

    private final BusColorDataStore dataStore;

    public BusColorRepositorySql(BusColorDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<BusColor> get() {
        return dataStore.getAll();
    }

    @Override
    public BusColor get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<BusColor> buses) {
        dataStore.save(buses);
    }
}
