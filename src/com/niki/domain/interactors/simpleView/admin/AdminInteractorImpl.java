package com.niki.domain.interactors.simpleView.admin;

import com.niki.domain.entities.Admin;
import com.niki.domain.entities.Person;
import com.niki.domain.gateways.repositories.PersonRepository;
import com.niki.domain.gateways.repositories.AdminRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdminInteractorImpl implements AdminInteractor {
    private final AdminRepository adminRepository;
    private final PersonRepository personRepository;

    public AdminInteractorImpl(AdminRepository adminRepository, PersonRepository personRepository) {
        this.adminRepository = adminRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<AdminContract> get() {
        var users = adminRepository.get();
        var positions = personRepository.get();

        var userContracts = new ArrayList<AdminContract>();
        for (var user : users) {

            var person = new Person(user.getPersonId());
            var index = Collections.binarySearch(positions, person, Comparator.comparingInt(Person::getId));
            person = index >= 0 ? positions.get(index) : null;

            userContracts.add(new AdminContract(
                    user.getId(),
                    user.getLogin(),
                    user.getPassword(),
                    person
            ));
        }

        return userContracts;
    }

    @Override
    public void save(List<AdminContract> adminContracts) {
        var users = new ArrayList<Admin>();
        for (var contract : adminContracts) {

            users.add(new Admin(contract.getId(),
                    contract.getPerson().getId(),
                    contract.getLogin(),
                    contract.getPassword())
            );
        }

        adminRepository.save(users);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.get();
    }

}
