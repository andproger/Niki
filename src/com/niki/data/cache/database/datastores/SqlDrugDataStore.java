package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Drug;

public class SqlDrugDataStore extends SqlDataStore<Drug> implements DrugDataStore {

    public SqlDrugDataStore() {
        super(Drug.class);
    }

    @Override
    protected Drug newItemInstance() {
        return new Drug();
    }
}
