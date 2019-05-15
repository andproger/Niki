package com.niki.presentation.dialogs.main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainDialog extends JDialog {
    private JPanel contentPane;

    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton usersButton;
    private JButton countriesButton;
    private JButton positionsButton;
    private JButton formsButton;
    private JButton manufactureresButton;
    private JButton arrivalButton;
    private JButton drugButton;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);

        initViews();

        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews(){
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        usersButton.addActionListener(actionEvent -> { });
        positionsButton.addActionListener(actionEvent -> { });
        countriesButton.addActionListener(actionEvent -> { });
        formsButton.addActionListener(actionEvent -> { });
        manufactureresButton.addActionListener(actionEvent -> { });
        drugButton.addActionListener(actionEvent -> { });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
