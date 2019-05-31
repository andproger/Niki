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

    @Column("address")
    private String address;

    @Column("email")
    private String email;

    @Column("number")
    private String number;

    public Provider() {

    }

    public Provider(int id, String name, String address, String email, String number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.number = number;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name;
    }
}
