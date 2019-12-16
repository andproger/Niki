package com.niki.domain.gateways.repositories;


import com.niki.domain.entities.Admin;

public interface UserAuthRepository {
    Admin getUser();
    boolean auth(String login, String password);
}
