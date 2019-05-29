package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.User;

import java.util.List;

public interface UserRepository {

    List<User> get();

    User get(int userId);

    void save(List<User> users);
}
