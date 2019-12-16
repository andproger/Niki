package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;

public class SqlBusModelDataStore extends SqlDataStore<BusModel> implements BusModelDataStore {

    public SqlBusModelDataStore() {
        super(BusModel.class);
    }

    @Override
    protected BusModel newItemInstance() {
        return new BusModel();
    }
}
