package com.niki.data.repository;

import com.niki.domain.entities.User;
import com.niki.domain.gateways.repositories.UserRepository;

import java.util.ArrayList;

public class UserRepositorySql implements UserRepository {
    @Override
    public ArrayList<User> getUsers() {
        var users = new ArrayList<User>();
        for (int i = 0; i < 10; i++)
            users.add(new User(i, 0, "", "", "", ""));
        return users;
    }

    @Override
    public void saveUsers(ArrayList<User> users) {

    }
}
