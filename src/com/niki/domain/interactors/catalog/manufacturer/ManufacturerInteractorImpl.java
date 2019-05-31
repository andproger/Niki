package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Country;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.gateways.repositories.CountryRepository;
import com.niki.domain.gateways.repositories.ManufacturerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManufacturerInteractorImpl implements ManufacturerInteractor {
    private final ManufacturerRepository manufacturerRepository;
    private final CountryRepository countryRepository;

    public ManufacturerInteractorImpl(ManufacturerRepository manufacturerRepository, CountryRepository countryRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public ArrayList<ManufacturerContract> getManufacturers() {
        var manufacturers = manufacturerRepository.getManufacturers();
        var countries = countryRepository.getCountries();

        var contracts = new ArrayList<ManufacturerContract>();
        for (var manufacturer : manufacturers) {
            var country = new Country(manufacturer.getId(), "", "");
            var index = Collections.binarySearch(countries, country, Comparator.comparingInt(Country::getId));
            country = index >= 0 ? countries.get(index) : null;
            contracts.add(new ManufacturerContract(manufacturer.getId(), manufacturer.getName(), manufacturer.getAddress(), country, "", "", ""));
        }
        return contracts;
    }

    @Override
    public void saveManufacturers(List<ManufacturerContract> manufacturerContracts) {
        var manufacturers = new ArrayList<Manufacturer>();
        for (var contract : manufacturerContracts) {
            manufacturers.add(new Manufacturer(
                    contract.getId(),
                    contract.getCountry().getId(),
                    contract.getName(),
                    contract.getAddress(),
                    contract.getEmail(),
                    contract.getPhone(),
                    contract.getSite())
            );
        }
        manufacturerRepository.saveManufacturers(manufacturers);
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }
}
