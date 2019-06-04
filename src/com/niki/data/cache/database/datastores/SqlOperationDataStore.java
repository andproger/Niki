package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Operation;

public class SqlOperationDataStore extends SqlDataStore<Operation> implements OperationDataStore {

    public SqlOperationDataStore() {
        super(Operation.class);
    }

    @Override
    protected Operation newItemInstance() {
        return new Operation();
    }
}
