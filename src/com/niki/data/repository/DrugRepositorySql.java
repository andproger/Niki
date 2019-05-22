package com.niki.data.repository;

import com.niki.data.cache.database.datastores.DrugDataStore;
import com.niki.domain.entities.Drug;
import com.niki.domain.gateways.repositories.DrugRepository;

import java.util.List;

public class DrugRepositorySql implements DrugRepository {

    private final DrugDataStore dataStore;

    public DrugRepositorySql(DrugDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Drug> getDrugs() {
        return dataStore.getAll();
    }

    @Override
    public void saveDrugs(List<Drug> drugs) {
        dataStore.save(drugs);
    }
}
