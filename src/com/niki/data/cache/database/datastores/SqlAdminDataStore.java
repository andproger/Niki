package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Admin;
import com.niki.domain.entities.Bus;

public class SqlAdminDataStore extends SqlDataStore<Admin> implements AdminDataStore {

    public SqlAdminDataStore() {
        super(Admin.class);
    }

    @Override
    protected Admin newItemInstance() {
        return new Admin();
    }
}
