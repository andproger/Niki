package com.niki.data.repository;

import com.niki.data.cache.database.datastores.CountryDataStore;
import com.niki.domain.entities.Country;
import com.niki.domain.gateways.repositories.CountryRepository;

import java.util.List;

public class CountryRepositorySql implements CountryRepository {
    private final CountryDataStore dataStore;

    public CountryRepositorySql(CountryDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Country> getCountries() {
        return dataStore.getAll();
    }

    @Override
    public void saveCountries(List<Country> countries) {
        dataStore.save(countries);
    }
}
