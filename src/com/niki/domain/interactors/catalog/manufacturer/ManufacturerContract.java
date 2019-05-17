package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Country;

public class ManufacturerContract {
    private int id;
    private String name;
    private String address;
    private Country country;

    public ManufacturerContract(int id, String name, String address, Country country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getName();
    }
}
