package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Country;

public class ManufacturerContract {
    private int id;
    private String name;
    private Country country;
    private Contact contact;

    public ManufacturerContract(int id, String name, Country country, Contact contact) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return getName();
    }
}
