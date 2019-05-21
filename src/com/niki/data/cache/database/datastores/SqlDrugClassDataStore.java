package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.DrugClass;

public class SqlDrugClassDataStore extends SqlDataStore<DrugClass> implements DrugClassDataStore {

    public SqlDrugClassDataStore() {
        super(DrugClass.class);
    }

    @Override
    protected DrugClass newItemInstance() {
        return new DrugClass();
    }
}
