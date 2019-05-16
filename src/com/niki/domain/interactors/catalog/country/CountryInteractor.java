package com.niki.domain.interactors.catalog.country;

import com.niki.domain.entities.Country;

import java.util.ArrayList;

public interface CountryInteractor {
    ArrayList<Country> getCountries();
    void saveCountries(ArrayList<Country> countries);
}
