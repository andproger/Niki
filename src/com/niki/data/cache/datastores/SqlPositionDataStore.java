package com.niki.data.cache.datastores;

import com.niki.data.cache.datastores.base.SqlDataStore;
import com.niki.domain.entities.Position;

public class SqlPositionDataStore extends SqlDataStore<Position> implements PositionDataStore {

    public SqlPositionDataStore() {
        super(Position.class);
    }

    @Override
    protected Position newItemInstance() {
        return new Position();
    }
}
