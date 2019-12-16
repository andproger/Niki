package com.niki.presentation.dialogs.login;

import com.niki.domain.interactors.login.LoginInteractor;

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView view;
    private final LoginInteractor loginInteractor;
    private final ConnectionSettingsRepository connectionSettingsRepository;

    LoginPresenterImpl(
            LoginView view,
            LoginInteractor loginInteractor,
            ConnectionSettingsRepository connectionSettingsRepository) {
        this.view = view;
        this.loginInteractor = loginInteractor;
        this.connectionSettingsRepository = connectionSettingsRepository;
    }

    @Override
    public void onViewReady() {
        ConnectionSettings settings = connectionSettingsRepository.get();

        if (settings != null && settings.getHost() != null) {
            view.renderServerText(settings.getHost());
        }
    }

    @Override
    public void onOkClicked(String server, String login, String password) {
        auth(server, login, password);
    }

    private void auth(String server, String login, String password) {
        view.showProgress(true);

        LoginInteractor.LoginResult result = loginInteractor.login(server, login, password);

        view.showProgress(false);
        switch (result) {
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
