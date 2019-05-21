package com.niki.data.repository;

import com.niki.data.cache.database.datastores.IntakeItemDataStore;
import com.niki.domain.entities.IntakeItem;
import com.niki.domain.gateways.repositories.IntakeItemRepository;

import java.util.ArrayList;

public class IntakeItemRepositorySql implements IntakeItemRepository {

    private final IntakeItemDataStore dataStore;

    public IntakeItemRepositorySql(IntakeItemDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<IntakeItem> get() {
        return dataStore.getAll();
    }

    @Override
    public ArrayList<IntakeItem> get(int intakeId) {
        return dataStore.get(intakeId);
    }

    @Override
    public void save(ArrayList<IntakeItem> items) {
        dataStore.save(items);
    }
}
