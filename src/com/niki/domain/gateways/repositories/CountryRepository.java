package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Country;

import java.util.ArrayList;

public interface CountryRepository {

    ArrayList<Country> getCountries();

    void saveCountries(ArrayList<Country> countries);
}
