package com.niki.data.repository;

import com.niki.data.cache.database.datastores.DrugClassDataStore;
import com.niki.domain.entities.DrugClass;
import com.niki.domain.gateways.repositories.ClassRepository;

import java.util.List;

public class ClassRepositorySql implements ClassRepository {

    private final DrugClassDataStore dataStore;

    public ClassRepositorySql(DrugClassDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<DrugClass> getClasses() {
        return dataStore.getAll();
    }

    @Override
    public void saveClasses(List<DrugClass> drugClasses) {
        dataStore.save(drugClasses);
    }
}
