package com.niki.domain.interactors.simpleView.driver;

import com.niki.domain.entities.Driver;
import com.niki.domain.entities.Person;
import com.niki.domain.gateways.repositories.DriverRepository;
import com.niki.domain.gateways.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DriverInteractorImpl implements DriverInteractor {
    private final DriverRepository driverRepository;
    private final PersonRepository personRepository;

    public DriverInteractorImpl(DriverRepository driverRepository, PersonRepository personRepository) {
        this.driverRepository = driverRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<DriverContract> get() {
        var users = driverRepository.get();
        var positions = personRepository.get();

        var userContracts = new ArrayList<DriverContract>();
        for (var user : users) {

            var person = new Person(user.getPersonId());
            var index = Collections.binarySearch(positions, person, Comparator.comparingInt(Person::getId));
            person = index >= 0 ? positions.get(index) : null;

            userContracts.add(new DriverContract(
                    user.getId(),
                    user.getIdCard(),
                    person
            ));
        }

        return userContracts;
    }

    @Override
    public void save(List<DriverContract> driverContracts) {
        var drivers = new ArrayList<Driver>();
        for (var contract : driverContracts) {
            drivers.add(new Driver(contract.getId(), contract.getPerson().getId(), contract.getCard()));
        }

        driverRepository.save(drivers);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.get();
    }

}
