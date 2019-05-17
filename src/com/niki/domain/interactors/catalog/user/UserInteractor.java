package com.niki.domain.interactors.catalog.user;

import com.niki.domain.entities.Position;

import java.util.ArrayList;

public interface UserInteractor {
    ArrayList<UserContract> getUsers();

    void saveUsers(ArrayList<UserContract> userContracts);

    ArrayList<Position> getPositions();
}
