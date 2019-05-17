package com.niki.data.cache.datastores;

import com.niki.data.cache.datastores.base.SqlDataStore;
import com.niki.domain.entities.Manufacturer;

public class SqlManufacturerDataStore extends SqlDataStore<Manufacturer> implements ManufacturerDataStore {

    public SqlManufacturerDataStore() {
        super(Manufacturer.class);
    }

    @Override
    protected Manufacturer newItemInstance() {
        return new Manufacturer();
    }
}
