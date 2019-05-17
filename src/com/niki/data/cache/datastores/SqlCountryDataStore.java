package com.niki.data.cache.datastores;


import com.niki.data.cache.datastores.base.SqlDataStore;
import com.niki.domain.entities.Country;



public class SqlCountryDataStore extends SqlDataStore<Country> implements CountryDataStore {

    public SqlCountryDataStore() {
        super(Country.class);
    }

    @Override
    protected Country newItemInstance() {
        return new Country();
    }
}
