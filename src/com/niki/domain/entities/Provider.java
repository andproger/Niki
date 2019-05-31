package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("provider")
public class Provider {
    @IntPrimaryKey("id")
    private int id;

    @Column("provider_name")
    private String name;

    @Column("contact_id")
    private Integer contactId;


    public Provider() {

    }

    public Provider(int id, String name, Integer contactId) {
        this.id = id;
        this.name = name;
        this.contactId = contactId;
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

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return name;
    }
}
