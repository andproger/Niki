package com.niki.data.repository;

import com.niki.data.cache.database.datastores.StationDataStore;
import com.niki.domain.entities.Station;
import com.niki.domain.gateways.repositories.StationRepository;

import java.util.List;

public class StationRepositorySql implements StationRepository {

    private final StationDataStore dataStore;

    public StationRepositorySql(StationDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Station> get() {
        return dataStore.getAll();
    }

    @Override
    public Station get(int id) {
        return dataStore.getItem(id);
    }

    @Override
    public void save(List<Station> buses) {
        dataStore.save(buses);
    }
}
