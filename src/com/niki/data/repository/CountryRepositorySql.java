package com.niki.data.repository;

import com.niki.domain.entities.Country;
import com.niki.domain.gateways.repositories.CountryRepository;

import java.util.ArrayList;

public class CountryRepositorySql implements CountryRepository {

    @Override
    public ArrayList<Country> getCountries() {
        var countries = new ArrayList<Country>();
        for (int i = 0; i < 10; i++)
            countries.add(new Country(i, "TEST", "ST"));
        return countries;
    }

    @Override
    public void saveCountries(ArrayList<Country> countries) {

    }
}
