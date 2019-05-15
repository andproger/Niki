package com.niki.presentation.app;

import com.niki.data.cache.Sql;
import com.niki.presentation.dialogs.login.LoginDialog;

public class Main {
    public static void main(String[] args) {
        Sql.init("25.48.169.93", "drugs", "admin", "admin");

        LoginDialog dialog = new LoginDialog();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
