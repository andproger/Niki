package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.User;

import java.util.ArrayList;

public interface UserRepository {

    ArrayList<User> getUsers();

    void saveUsers(ArrayList<User> users);
}
