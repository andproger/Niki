package com.niki.presentation.app;

import com.niki.data.cache.Sql;
import com.niki.presentation.dialogs.main.MainDialog;

public class Main {
    public static void main(String[] args) {
        Sql.init("25.48.169.93", "drugs", "admin", "admin");

        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
