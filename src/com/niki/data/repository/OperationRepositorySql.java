package com.niki.data.repository;

import com.niki.data.cache.database.datastores.FormDataStore;
import com.niki.data.cache.database.datastores.OperationDataStore;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Operation;
import com.niki.domain.gateways.repositories.OperationRepository;

import java.util.List;


public class OperationRepositorySql implements OperationRepository {

    private final OperationDataStore dataStore;

    public OperationRepositorySql(OperationDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Operation> get() {
        return dataStore.getAll();
    }

    @Override
    public void save(List<Operation> operations) {
        dataStore.save(operations);
    }
}
