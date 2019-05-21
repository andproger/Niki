package com.niki.data.cache.datastores;

import com.niki.data.cache.datastores.base.SqlDataStore;
import com.niki.domain.entities.IntakeItem;

public class SqlIntakeItemDataStore extends SqlDataStore<IntakeItem> implements IntakeItemDataStore {

    public SqlIntakeItemDataStore() {
        super(IntakeItem.class);
    }

    @Override
    protected IntakeItem newItemInstance() {
        return new IntakeItem();
    }

}
