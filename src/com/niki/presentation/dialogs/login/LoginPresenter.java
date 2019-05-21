package com.niki.presentation.dialogs.login;

public interface LoginPresenter {
    void onViewReady();

    void onOkClicked(String server, String login, String password);
}
