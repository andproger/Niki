package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Form;

public class SqlFormDataStore extends SqlDataStore<Form> implements FormDataStore {

    public SqlFormDataStore() {
        super(Form.class);
    }

    @Override
    protected Form newItemInstance() {
        return new Form();
    }
}
