package com.niki.data.repository;

import com.niki.data.cache.database.datastores.ProviderDataStore;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.ProviderRepository;

import java.util.ArrayList;

public class ProviderRepositorySql implements ProviderRepository {

    private final ProviderDataStore dataStore;

    public ProviderRepositorySql(ProviderDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<Provider> get() {
        return dataStore.getAll();
    }

    @Override
    public void save(ArrayList<Provider> items) {
        dataStore.save(items);
    }
}
