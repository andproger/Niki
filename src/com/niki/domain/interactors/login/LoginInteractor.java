package com.niki.domain.interactors.login;

public interface LoginInteractor {
    LoginResult login(String server, String login, String password);

    enum  LoginResult{
        WRONG_CONNECTION,
        WRONG_LOGIN,
        SUCCESS_LOGIN
    }
}
