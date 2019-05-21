package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.User;

public class SqlUserDataStore extends SqlDataStore<User> implements UserDataStore {

    public SqlUserDataStore() {
        super(User.class);
    }

    @Override
    protected User newItemInstance() {
        return new User();
    }
}
