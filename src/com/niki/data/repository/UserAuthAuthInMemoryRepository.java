package com.niki.data.repository;

import com.niki.data.cache.database.datastores.AdminDataStore;
import com.niki.domain.entities.Admin;

public class UserAuthAuthInMemoryRepository implements UserAuthRepository {
    private static Admin currentUser;
    private final AdminDataStore dataStore;

    public UserAuthAuthInMemoryRepository(AdminDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Admin getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean auth(String login, String password) {
        //TODO всё что ты делаешь это плохо
        var users = dataStore.getAll();

        for (var user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }
}
