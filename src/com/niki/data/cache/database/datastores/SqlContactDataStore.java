package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Contact;

import java.util.ArrayList;

public class SqlContactDataStore extends SqlDataStore<Contact> implements ContactDataStore {

    public SqlContactDataStore() {
        super(Contact.class);
    }

    @Override
    protected Contact newItemInstance() {
        return new Contact();
    }

    @Override
    public int save(Contact contact) {
        if (contact.getId() == 0)
            return insertContact(contact);
        else
            return updateContact(contact);
    }

    private int insertContact(Contact contact) {
        var sqlInsert = sqlGen.insert();
        var contacts = new ArrayList<Contact>();
        contacts.add(contact);
        var keys = insertItems(contacts, sqlInsert);
        return keys.get(0);
    }

    private int updateContact(Contact contact) {
        var sqlUpdate = sqlGen.update(" where " + primaryKey + " = ?" );
        var contacts = new ArrayList<Contact>();
        contacts.add(contact);
        updateItems(contacts, sqlUpdate);
        return contact.getId();
    }
}
