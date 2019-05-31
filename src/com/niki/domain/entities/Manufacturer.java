package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("manufacturer")
public class Manufacturer {

    @IntPrimaryKey("id")
    private int id;

    @Column("country_id")
    private int countryId;

    @Column("manufacturer_name")
    private String name;

    @Column("address")
    private String address;

    @Column("email")
    private String email;

    @Column("phone")
    private String phone;

    @Column("site")
    private String site;

    public Manufacturer() {

    }

    public Manufacturer(int id, int countryId, String name, String address, String email, String phone, String site) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.address = address;
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
