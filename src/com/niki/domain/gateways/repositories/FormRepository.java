package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Form;

import java.util.ArrayList;

public interface FormRepository {

    ArrayList<Form> getForms();

    void saveForms(ArrayList<Form> forms);
}
