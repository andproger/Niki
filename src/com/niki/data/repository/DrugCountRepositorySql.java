package com.niki.data.repository;

import com.niki.data.cache.database.datastores.DrugCountDataStore;
import com.niki.domain.entities.DrugCount;
import com.niki.domain.gateways.repositories.DrugCountRepository;

public class DrugCountRepositorySql implements DrugCountRepository {

    private final DrugCountDataStore dataStore;

    public DrugCountRepositorySql(DrugCountDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public DrugCount get(int drugId) {
        return dataStore.get(drugId);
    }
}
