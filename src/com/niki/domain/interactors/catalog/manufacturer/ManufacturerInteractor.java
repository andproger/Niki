package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Country;

import java.util.List;

public interface ManufacturerInteractor {
    List<ManufacturerContract> getManufacturers();

    void saveManufacturers(List<ManufacturerContract> manufactures);

    List<Country> getCountries();

}
