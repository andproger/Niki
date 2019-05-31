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

    @Column("contact_id")
    private Integer contactId;

    @Column("manufacturer_name")
    private String name;

    public Manufacturer() {

    }

    public Manufacturer(int id, int countryId, String name, Integer contactId) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.contactId = contactId;
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

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return getName();
    }
}
