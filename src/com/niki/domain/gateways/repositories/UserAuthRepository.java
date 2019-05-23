package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.UserAuth;

public interface UserAuthRepository {
    UserAuth getUser();
    boolean auth(String login, String password);
}
