package com.niki.domain.interactors.catalog.user;

import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Position;
import com.niki.domain.entities.User;
import com.niki.domain.gateways.repositories.ContactRepository;
import com.niki.domain.gateways.repositories.PositionRepository;
import com.niki.domain.gateways.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserInteractorImpl implements UserInteractor {
    private final UserRepository userRepository;
    private final ContactRepository contactRepository;
    private final PositionRepository positionRepository;

    public UserInteractorImpl(UserRepository userRepository, ContactRepository contactRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<UserContract> getUsers() {
        var users = userRepository.get();
        var contacts = contactRepository.get();
        var positions = positionRepository.get();

        var userContracts = new ArrayList<UserContract>();
        for (var user : users) {

            var position = new Position(user.getPositionId(), 0, "", false);
            var index = Collections.binarySearch(positions, position, Comparator.comparingInt(Position::getId));
            position = index >= 0 ? positions.get(index) : null;

            var contact = new Contact(user.getContactId() == null? 0 : user.getContactId());
            index = Collections.binarySearch(contacts, contact, Comparator.comparingInt(Contact::getId));
            contact = index >= 0 ? contacts.get(index) : new Contact(0, "", "", "", "");

            userContracts.add(new UserContract(
                    user.getId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    position,
                    contact
            ));
        }

        return userContracts;
    }

    @Override
    public void saveUsers(List<UserContract> userContracts) {
        var users = new ArrayList<User>();
        for (var contract : userContracts) {
            var contactId = contactRepository.save(contract.getContact());
            contract.getContact().setId(contactId);

            users.add(new User(contract.getId(),
                    contract.getPosition().getId(),
                    contract.getLogin(),
                    contract.getPassword(),
                    contract.getFirstName(),
                    contract.getLastName(),
                    contactId != 0 ? contactId : null)
            );
        }

        userRepository.save(users);
    }

    @Override
    public List<Position> getPositions() {
        return positionRepository.get();
    }


}
