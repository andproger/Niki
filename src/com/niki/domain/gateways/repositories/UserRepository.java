package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void saveUsers(List<User> users);
}
