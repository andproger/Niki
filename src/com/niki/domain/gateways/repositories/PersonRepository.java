package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> get();

    Person get(int personId);

    void save(List<Person> persons);
}
