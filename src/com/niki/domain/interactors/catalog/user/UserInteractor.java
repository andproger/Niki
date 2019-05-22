package com.niki.domain.interactors.catalog.user;

import com.niki.domain.entities.Position;

import java.util.List;

public interface UserInteractor {
    List<UserContract> getUsers();

    void saveUsers(List<UserContract> userContracts);

    List<Position> getPositions();
}
