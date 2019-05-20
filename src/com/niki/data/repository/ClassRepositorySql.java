package com.niki.data.repository;

import com.niki.data.cache.datastores.DrugClassDataStore;
import com.niki.domain.entities.DrugClass;
import com.niki.domain.gateways.repositories.ClassRepository;

import java.util.ArrayList;

public class ClassRepositorySql implements ClassRepository {

    private final DrugClassDataStore dataStore;

    public ClassRepositorySql(DrugClassDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<DrugClass> getClasses() {
        return dataStore.getAll();
    }

    @Override
    public void saveClasses(ArrayList<DrugClass> drugClasses) {
        dataStore.save(drugClasses);
    }
}
