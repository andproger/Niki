package com.niki.domain.interactors.catalog.user;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Position;
import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.*;
import com.niki.domain.interactors.catalog.drug.DrugContract;
import com.niki.domain.interactors.catalog.drug.DrugInteractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserInteractorImpl implements UserInteractor {
    UserRepository userRepository;
    PositionRepository positionRepository;

    public UserInteractorImpl(UserRepository userRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public ArrayList<UserContract> getUsers() {
        var users = userRepository.getUsers();
        var positions = positionRepository.getPositions();

        var userContracts = new ArrayList<UserContract>();
        for(var user : users){
            var position = new Position(user.getPositionId(),0, "");
            var index = Collections.binarySearch(positions, position, Comparator.comparingInt(Position::getId));
            position = index >= 0 ? positions.get(index) : null;
            userContracts.add(new UserContract(user.getId(), user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), position));
        }

        return userContracts;
    }

    @Override
    public void saveUsers(ArrayList<UserContract> userContracts) {

    }

    @Override
    public ArrayList<Position> getPositions() {
        return positionRepository.getPositions();
    }
}
