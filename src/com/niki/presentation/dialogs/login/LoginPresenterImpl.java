package com.niki.presentation.dialogs.login;

import com.niki.domain.interactors.login.LoginInteractor;

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView view;
    private final LoginInteractor loginInteractor;

    LoginPresenterImpl(
            LoginView view,
            LoginInteractor loginInteractor
    ) {
        this.view = view;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void onOkClicked(String server, String login, String password) {
        auth(server, login, password);
    }

    private void auth(String server, String login, String password) {
        view.showProgress(true);

        LoginInteractor.LoginResult result = loginInteractor.login(server, login, password);

        view.showProgress(false);
        switch (result){
            case SUCCESS_LOGIN:
                view.onSuccessLogin();
                break;

            case WRONG_LOGIN:
                view.onWrongLogin();
                break;

            case WRONG_CONNECTION:
                view.onWrongConnection();
                break;
        }
    }
}
