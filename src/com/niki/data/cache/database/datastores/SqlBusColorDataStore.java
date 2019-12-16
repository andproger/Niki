package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.BusColor;

public class SqlBusColorDataStore extends SqlDataStore<BusColor> implements BusColorDataStore {

    public SqlBusColorDataStore() {
        super(BusColor.class);
    }

    @Override
    protected BusColor newItemInstance() {
        return new BusColor();
    }
}
