package com.niki.domain.interactors.catalog.provider;

import com.niki.domain.entities.Contact;

public class ProviderContract {
    private int id;
    private String name;
    private Contact contact;

    public ProviderContract(int id, String name, Contact contact) {
        this.id = id;
        this.name = name;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
