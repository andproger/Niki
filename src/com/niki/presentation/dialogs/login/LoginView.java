package com.niki.presentation.dialogs.login;

public interface LoginView {
    void renderServerText(String host);

    void onSuccessLogin();

    void onWrongLogin();

    void onWrongConnection();

    void showProgress(boolean show);
}
