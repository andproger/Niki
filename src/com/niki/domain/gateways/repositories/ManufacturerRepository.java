package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Manufacturer;

import java.util.List;

public interface ManufacturerRepository {

    List<Manufacturer> getManufacturers();

    void saveManufacturers(List<Manufacturer> manufacturers);
}
