package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusModel;

public class SqlBusBrandDataStore extends SqlDataStore<BusBrand> implements BusBrandDataStore {

    public SqlBusBrandDataStore() {
        super(BusBrand.class);
    }

    @Override
    protected BusBrand newItemInstance() {
        return new BusBrand();
    }
}
