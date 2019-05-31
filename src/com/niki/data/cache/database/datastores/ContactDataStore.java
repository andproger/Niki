package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.Contact;

public interface ContactDataStore extends DataStore<Contact> {
    int save(Contact contact);
}
