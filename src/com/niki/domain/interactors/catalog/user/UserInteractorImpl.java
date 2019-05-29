package com.niki.domain.interactors.catalog.user;

import com.niki.domain.entities.Position;
import com.niki.domain.gateways.repositories.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserInteractorImpl implements UserInteractor {
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;

    public UserInteractorImpl(UserRepository userRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<UserContract> getUsers() {
        var users = userRepository.get();
        var positions = positionRepository.get();

        var userContracts = new ArrayList<UserContract>();
        for(var user : users){
            var position = new Position(user.getPositionId(),0, "", false);
            var index = Collections.binarySearch(positions, position, Comparator.comparingInt(Position::getId));
            position = index >= 0 ? positions.get(index) : null;
            userContracts.add(new UserContract(user.getId(), user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), position));
        }

        return userContracts;
    }

    @Override
    public void saveUsers(List<UserContract> userContracts) {

    }

    @Override
    public List<Position> getPositions() {
        return positionRepository.get();
    }
}
