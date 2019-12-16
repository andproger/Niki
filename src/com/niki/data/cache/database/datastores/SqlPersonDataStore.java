package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Person;

public class SqlPersonDataStore extends SqlDataStore<Person> implements PersonDataStore {

    public SqlPersonDataStore() {
        super(Person.class);
    }

    @Override
    protected Person newItemInstance() {
        return new Person();
    }
}
