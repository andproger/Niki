package com.niki.data.repository;

import com.niki.data.cache.database.datastores.IntakeDataStore;
import com.niki.domain.entities.Intake;
import com.niki.domain.gateways.repositories.IntakeRepository;

import java.util.List;

public class IntakeRepositorySql implements IntakeRepository {

    private final IntakeDataStore dataStore;

    public IntakeRepositorySql(IntakeDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Intake> get() {
        return dataStore.getAll();
    }

    @Override
    public int save(Intake intake) {
        return dataStore.save(intake);
    }

    @Override
    public void deleteById(int id) {
        dataStore.deleteById(id);
    }

}
