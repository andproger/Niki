package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Country;

import java.util.ArrayList;

public interface ManufacturerInteractor {
    ArrayList<ManufacturerContract> getManufacturers();

    void saveManufacturers(ArrayList<ManufacturerContract> manufactures);

    ArrayList<Country> getCountries();

}
