package com.niki.data.repository;

import com.niki.data.cache.database.datastores.AdminDataStore;
import com.niki.data.cache.database.datastores.BusDataStore;
import com.niki.domain.entities.Admin;
import com.niki.domain.entities.Bus;
import com.niki.domain.gateways.repositories.AdminRepository;
import com.niki.domain.gateways.repositories.BusRepository;

import java.util.List;

public class BusRepositorySql implements BusRepository {

    private final BusDataStore dataStore;

    public BusRepositorySql(BusDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Bus> get() {
        return dataStore.getAll();
    }

    @Override
    public Bus get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<Bus> buses) {
        dataStore.save(buses);
    }
}
