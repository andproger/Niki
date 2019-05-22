package com.niki.data.repository;

import com.niki.data.cache.database.datastores.StorageDataStore;
import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.StorageRepository;

import java.util.List;

public class StorageRepositorySql implements StorageRepository {

    private final StorageDataStore dataStore;

    public StorageRepositorySql(StorageDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Storage> getStorages() {
        return dataStore.getAll();
    }

    @Override
    public void saveStorages(List<Storage> storages) {
        dataStore.save(storages);
    }
}
