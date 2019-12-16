package com.niki.domain.interactors.simpleView.person;

import com.niki.domain.entities.Person;

import java.util.List;

public interface PersonInteractor {
    List<Person> get();

    void save(List<Person> items);
}
