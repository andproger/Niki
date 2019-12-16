package com.niki.domain.interactors.simpleView.admin;

import com.niki.domain.entities.Person;

import java.util.List;

public interface AdminInteractor {
    List<AdminContract> get();

    void save(List<AdminContract> adminContracts);

    List<Person> getPersons();
}
