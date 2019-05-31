package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Country;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.gateways.repositories.ContactRepository;
import com.niki.domain.gateways.repositories.CountryRepository;
import com.niki.domain.gateways.repositories.ManufacturerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManufacturerInteractorImpl implements ManufacturerInteractor {
    private final ManufacturerRepository manufacturerRepository;
    private final ContactRepository contactRepository;
    private final CountryRepository countryRepository;

    public ManufacturerInteractorImpl(ManufacturerRepository manufacturerRepository, ContactRepository contactRepository, CountryRepository countryRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.contactRepository = contactRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public ArrayList<ManufacturerContract> getManufacturers() {
        var manufacturers = manufacturerRepository.getManufacturers();
        var countries = countryRepository.getCountries();
        var contacts = contactRepository.get();

        var contracts = new ArrayList<ManufacturerContract>();
        for (var manufacturer : manufacturers) {

            var country = new Country(manufacturer.getCountryId(), "", "");
            var index = Collections.binarySearch(countries, country, Comparator.comparingInt(Country::getId));
            country = index >= 0 ? countries.get(index) : null;

            var contact = new Contact(manufacturer.getContactId() != null ? manufacturer.getContactId() : 0, "", "", "", "");
            index = Collections.binarySearch(contacts, contact, Comparator.comparingInt(Contact::getId));
            contact = index >= 0 ? contacts.get(index) : new Contact(0, "", "", "", "");

            contracts.add(new ManufacturerContract(manufacturer.getId(), manufacturer.getName(), country, contact));
        }
        return contracts;
    }

    @Override
    public void saveManufacturers(List<ManufacturerContract> manufacturerContracts) {
        var manufacturers = new ArrayList<Manufacturer>();
        for (var contract : manufacturerContracts) {
            var contactId = contactRepository.save(contract.getContact());
            contract.getContact().setId(contactId);

            manufacturers.add(new Manufacturer(
                    contract.getId(),
                    contract.getCountry().getId(),
                    contract.getName(),
                    contactId != 0 ? contactId : null));
        }
        manufacturerRepository.saveManufacturers(manufacturers);
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }
}
