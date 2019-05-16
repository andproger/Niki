package com.niki.domain.interactors.login;

import com.niki.domain.gateways.connection.ConnectionService;

public class LoginInteractorImpl implements LoginInteractor {

    private final ConnectionService connectionService;

    public LoginInteractorImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public LoginResult login(String server, String login, String password) {
        if (connectionService.checkConnection(server)) {
            //TODO validate login
            return LoginResult.SUCCESS_LOGIN;
        } else {
            return LoginResult.WRONG_CONNECTION;
        }
    }
}
