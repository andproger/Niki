package com.niki.data.repository;

import com.niki.data.cache.database.datastores.PersonDataStore;
import com.niki.domain.entities.Person;
import com.niki.domain.gateways.repositories.PersonRepository;

import java.util.List;

public class PersonRepositorySql implements PersonRepository {

    private final PersonDataStore dataStore;

    public PersonRepositorySql(PersonDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Person> get() {
        return dataStore.getAll();
    }

    @Override
    public Person get(int positionId) {
        return dataStore.getItem(positionId);
    }

    @Override
    public void save(List<Person> positions) {
        dataStore.save(positions);
    }
}
