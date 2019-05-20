package com.niki.domain.entities;

public class Manufacturer {
    private int id;
    private int countryId;
    private String name;
    private String address;

    public Manufacturer() {

    }

    public Manufacturer(int id, int countryId, String name, String address) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

    @Override
    public String toString() {
        return getName();
    }
}
