package com.niki.data.repository;

import com.niki.data.cache.database.datastores.ContactDataStore;
import com.niki.domain.entities.Contact;
import com.niki.domain.gateways.repositories.ContactRepository;

import java.util.List;

public class ContactRepositorySql implements ContactRepository {

    private final ContactDataStore dataStore;

    public ContactRepositorySql(ContactDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Contact> get() {
        return dataStore.getAll();
    }

    @Override
    public Contact get(int userId) {
        return dataStore.getItem(userId);
    }

    @Override
    public int save(Contact contact) {
        if (contact.getPhone().isEmpty() &&
                contact.getEmail().isEmpty() &&
                contact.getAddress().isEmpty() &&
                contact.getSite().isEmpty()
        ) {
            return 0;
        }

        return dataStore.save(contact);
    }
}
