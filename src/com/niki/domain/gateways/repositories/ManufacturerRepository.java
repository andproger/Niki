package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Manufacturer;

import java.util.ArrayList;

public interface ManufacturerRepository {

    ArrayList<Manufacturer> getManufacturers();

    void saveManufacturers(ArrayList<Manufacturer> manufacturers);
}
