package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> get();

    Contact get(int contactId);

    int save(Contact contact);
}
