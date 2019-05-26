package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Indication;

public class SqlIndicationDataStore extends SqlDataStore<Indication> implements IndicationDataStore {

    public SqlIndicationDataStore() {
        super(Indication.class);
    }

    @Override
    protected Indication newItemInstance() {
        return new Indication();
    }
}
