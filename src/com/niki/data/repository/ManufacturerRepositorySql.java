package com.niki.data.repository;

import com.niki.domain.entities.Manufacturer;
import com.niki.domain.gateways.repositories.ManufacturerRepository;

import java.util.ArrayList;

public class ManufacturerRepositorySql implements ManufacturerRepository {

    @Override
    public ArrayList<Manufacturer> getManufacturers() {
        var manufacturers = new ArrayList<Manufacturer>();
        for (int i = 0; i < 10; i++)
            manufacturers.add(new Manufacturer(i, 0, "TEST", "Address"));
        return manufacturers;
    }

    @Override
    public void saveManufacturers(ArrayList<Manufacturer> manufacturers) {

    }
}
