package com.niki.domain.interactors.catalog.manufacturer;

import com.niki.domain.entities.Country;

public class ManufacturerContract {
    private int id;
    private String name;
    private String address;
    private Country country;
    private String email;
    private String phone;
    private String site;

    public ManufacturerContract(int id, String name, String address, Country country, String email, String phone, String site) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.site = site;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return getName();
    }
}
