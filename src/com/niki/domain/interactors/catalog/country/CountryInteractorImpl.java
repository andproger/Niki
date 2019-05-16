package com.niki.domain.interactors.catalog.country;

import com.niki.domain.entities.Country;

import java.util.ArrayList;

public class CountryInteractorImpl implements CountryInteractor {
    @Override
    public ArrayList<Country> getCountries() {
        var countries = new ArrayList<Country>();
        var country = new Country(0, "TEST", "ST");
        for (int i = 0; i < 10; i++)
            countries.add(country);
        return countries;
    }

    @Override
    public void saveCountries(ArrayList<Country> countries) {

    }
}
