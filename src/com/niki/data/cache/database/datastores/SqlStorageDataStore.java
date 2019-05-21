package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Storage;

public class SqlStorageDataStore extends SqlDataStore<Storage> implements StorageDataStore {
    public SqlStorageDataStore() {
        super(Storage.class);
    }

    @Override
    protected Storage newItemInstance() {
        return new Storage();
    }
}
