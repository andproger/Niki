package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> getCountries();

    void saveCountries(List<Country> countries);
}
