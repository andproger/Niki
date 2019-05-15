package com.niki.presentation.dialogs.catalog;

import javax.swing.*;
import java.awt.event.*;

public class CatalogDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonAdd;
    private JButton deleteButton;
    private JTable table1;

    public CatalogDialog() {
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

    private void initViews() {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
    }

    private void onOK() {
        // buttonAdd your code here
        dispose();
    }

    private void onCancel() {
        // buttonAdd your code here if necessary
        dispose();
    }
}
