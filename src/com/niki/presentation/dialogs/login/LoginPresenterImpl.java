package com.niki.presentation.dialogs.login;

import com.niki.domain.gateways.connection.ConnectionService;
import com.niki.domain.interactors.login.LoginInteractor;

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView view;
    private final LoginInteractor loginInteractor;
    private final ConnectionService connectionService;

    LoginPresenterImpl(
            LoginView view,
            LoginInteractor loginInteractor,
            ConnectionService connectionService
    ) {
        this.view = view;
        this.loginInteractor = loginInteractor;
        this.connectionService = connectionService;
    }

    @Override
    public void onOkClicked(String server, String login, String password) {
        auth(server, login, password);
    }

    private void auth(String server, String login, String password) {
        view.showProgress(true);
        if (connectionService.checkConnection(server)) {

            if (loginInteractor.login(login, password)) {
                view.showProgress(false);
                view.onSuccessLogin();
            } else {
                view.showProgress(false);
                view.onWrongLogin();
            }

        } else {
            view.showProgress(false);
            view.onWrongConnection();
        }
    }
}
