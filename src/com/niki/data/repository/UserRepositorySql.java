package com.niki.data.repository;

import com.niki.data.cache.database.datastores.UserDataStore;
import com.niki.domain.entities.User;
import com.niki.domain.gateways.repositories.UserRepository;

import java.util.List;

public class UserRepositorySql implements UserRepository {

    private final UserDataStore dataStore;

    public UserRepositorySql(UserDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<User> getUsers() {
        return dataStore.getAll();
    }

    @Override
    public void saveUsers(List<User> users) {
        dataStore.save(users);
    }
}
