package com.niki.data.repository;

import com.niki.data.cache.database.datastores.UserDataStore;
import com.niki.domain.entities.User;
import com.niki.domain.gateways.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;


public class UserRepositorySql implements UserRepository {

    private final UserDataStore dataStore;

    public UserRepositorySql(UserDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<User> getUsers() {
        var users = new ArrayList<User>();

        //TODO implement real user list
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, 0, "", "", "", ""));
        }
        return users;
    }

    @Override
    public void saveUsers(List<User> users) {

    }
}
