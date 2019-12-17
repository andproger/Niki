package com.niki.domain.interactors.simpleView.driver;

import com.niki.domain.entities.Person;

import java.util.List;

public interface DriverInteractor {
    List<DriverContract> get();

    void save(List<DriverContract> driverContracts);

    List<Person> getPersons();
}
