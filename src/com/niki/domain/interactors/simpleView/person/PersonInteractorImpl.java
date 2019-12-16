package com.niki.domain.interactors.simpleView.person;

import com.niki.domain.entities.Admin;
import com.niki.domain.entities.Person;
import com.niki.domain.gateways.repositories.AdminRepository;
import com.niki.domain.gateways.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonInteractorImpl implements PersonInteractor {
    private final PersonRepository personRepository;

    public PersonInteractorImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> get() {
        return personRepository.get();
    }

    @Override
    public void save(List<Person> items) {
        personRepository.save(items);
    }
}
