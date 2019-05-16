package com.niki.data.repository;

import com.niki.domain.entities.Form;
import com.niki.domain.gateways.repositories.FormRepository;

import java.util.ArrayList;

public class FormRepositorySql implements FormRepository {

    @Override
    public ArrayList<Form> getForms() {
        var forms = new ArrayList<Form>();
        var form = new Form(0, "TEST");
        for (int i = 0; i < 10; i++)
            forms.add(form);
        return forms;
    }

    @Override
    public void saveForms(ArrayList<Form> forms) {

    }
}
