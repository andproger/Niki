package com.niki.data.repository;

import com.niki.data.cache.database.datastores.AdminDataStore;
import com.niki.domain.entities.Admin;
import com.niki.domain.gateways.repositories.AdminRepository;

import java.util.List;

public class BusRepositorySql implements AdminRepository {

    private final AdminDataStore dataStore;

    public BusRepositorySql(AdminDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Admin> get() {
        return dataStore.getAll();
    }

    @Override
    public Admin get(int userId) {
        return dataStore.getItem(userId);
    }

    @Override
    public void save(List<Admin> users) {
        dataStore.save(users);
    }
}
