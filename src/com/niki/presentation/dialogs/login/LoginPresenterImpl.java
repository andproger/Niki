package com.niki.presentation.dialogs.login;

import com.niki.domain.interactors.login.LoginInteractor;

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView view;
    private final LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView view, LoginInteractor loginInteractor) {
        this.view = view;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void onOkClicked(String server, String login, String password) {

        if (loginInteractor.login(login, password)) {
            view.onSuccessLogin();
        } else {
            view.onWrongLogin();
        }
    }
}
