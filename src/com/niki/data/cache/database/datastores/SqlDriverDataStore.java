package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Admin;
import com.niki.domain.entities.Driver;

public class SqlDriverDataStore extends SqlDataStore<Driver> implements DriverDataStore {

    public SqlDriverDataStore() {
        super(Driver.class);
    }

    @Override
    protected Driver newItemInstance() {
        return new Driver();
    }
}
