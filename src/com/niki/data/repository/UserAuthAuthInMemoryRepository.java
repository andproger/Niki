package com.niki.data.repository;

import com.niki.data.cache.database.datastores.UserDataStore;
import com.niki.domain.entities.UserAuth;
import com.niki.domain.gateways.repositories.UserAuthRepository;

public class UserAuthAuthInMemoryRepository implements UserAuthRepository {
    private static UserAuth userAuth;
    private final UserDataStore dataStore;

    public UserAuthAuthInMemoryRepository(UserDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public UserAuth getUser() {
        return userAuth;
    }

    @Override
    public boolean auth(String login, String password) {
        //TODO всё что ты делаешь это плохо
        for (var user : dataStore.getAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                userAuth = new UserAuth(user.getId());
                return true;
            }
        }

        return false;
    }
}
