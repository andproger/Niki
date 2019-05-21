package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Provider;

public class SqlProviderDataStore extends SqlDataStore<Provider> implements ProviderDataStore {

    public SqlProviderDataStore() {
        super(Provider.class);
    }

    @Override
    protected Provider newItemInstance() {
        return new Provider();
    }
}
