package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Bus;

public class SqlBusDataStore extends SqlDataStore<Bus> implements BusDataStore {

    public SqlBusDataStore() {
        super(Bus.class);
    }

    @Override
    protected Bus newItemInstance() {
        return new Bus();
    }
}
