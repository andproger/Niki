package com.niki.data.repository;

import com.niki.data.cache.database.datastores.FormDataStore;
import com.niki.domain.entities.Form;
import com.niki.domain.gateways.repositories.FormRepository;

import java.util.ArrayList;

public class FormRepositorySql implements FormRepository {

    private final FormDataStore dataStore;

    public FormRepositorySql(FormDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<Form> getForms() {
        return dataStore.getAll();
    }

    @Override
    public void saveForms(ArrayList<Form> forms) {
        dataStore.save(forms);
    }
}
