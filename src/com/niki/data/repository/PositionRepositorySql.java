package com.niki.data.repository;

import com.niki.data.cache.database.datastores.PositionDataStore;
import com.niki.domain.entities.Position;
import com.niki.domain.gateways.repositories.PositionRepository;

import java.util.List;

public class PositionRepositorySql implements PositionRepository {

    private final PositionDataStore dataStore;

    public PositionRepositorySql(PositionDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Position> getPositions() {
        return dataStore.getAll();
    }

    @Override
    public void savePositions(List<Position> positions) {
        dataStore.save(positions);
    }
}
