package com.niki.data.repository;

import com.niki.data.cache.database.datastores.IndicationDataStore;
import com.niki.domain.entities.Indication;
import com.niki.domain.gateways.repositories.IndicationRepository;

import java.util.List;

public class IndicationRepositorySql implements IndicationRepository {

    private final IndicationDataStore dataStore;

    public IndicationRepositorySql(IndicationDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Indication> get() {
        return dataStore.getAll();
    }

    @Override
    public void save(List<Indication> indications) {
        dataStore.save(indications);
    }
}
