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
    public List<User> get() {
        return dataStore.getAll();
    }

    @Override
    public User get(int userId) {
        return dataStore.getItem(userId);
    }

    @Override
    public void save(List<User> users) {
        dataStore.save(users);
    }
}
