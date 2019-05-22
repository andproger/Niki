package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Form;

import java.util.List;

public interface FormRepository {

    List<Form> getForms();

    void saveForms(List<Form> forms);
}
