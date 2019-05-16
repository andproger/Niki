package com.niki.presentation.app;

import com.niki.data.cache.Sql;
import com.niki.presentation.dialogs.login.LoginDialog;
import com.niki.presentation.dialogs.main.MainDialog;

public class Main {
    public static void main(String[] args) {
        Sql.init("VSS", "drugs", "admin", "admin");

        LoginDialog dialog = new LoginDialog();
        dialog.pack();
        dialog.setVisible(true);
        if (dialog.getResult() == LoginDialog.ResultType.SUCCESS_LOGIN)
            openMainDialog();

        System.exit(0);
    }

    private static void openMainDialog() {
        var dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}
