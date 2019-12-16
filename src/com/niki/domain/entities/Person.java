package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("person")
public class Person {
    @IntPrimaryKey("id")
    int id;
    @Column("first_name")
    String firstName;
    @Column("last_name")
    String lastName;
    @Column("home_address")
    String homeAddress;
    @Column("number")
    String number;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String firstName, String lastName, String homeAddress, String number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  lastName;
    }
}
