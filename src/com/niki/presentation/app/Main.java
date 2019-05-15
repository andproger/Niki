package com.niki.presentation.app;

import com.niki.presentation.dialogs.main.MainDialog;

public class Main {
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
