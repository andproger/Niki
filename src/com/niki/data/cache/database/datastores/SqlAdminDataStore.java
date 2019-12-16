package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Bus;

public class SqlAdminDataStore extends SqlDataStore<Bus> implements AdminDataStore {

    public SqlAdminDataStore() {
        super(Bus.class);
    }

    @Override
    protected Bus newItemInstance() {
        return new Bus();
    }
}
