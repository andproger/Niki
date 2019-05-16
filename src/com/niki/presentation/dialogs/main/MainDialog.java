package com.niki.presentation.dialogs.main;

import com.niki.presentation.dialogs.catalog.CatalogDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainDialog extends JDialog {
    private JPanel contentPane;

    private JButton buttonExit;
    private JButton usersButton;
    private JButton countriesButton;
    private JButton positionsButton;
    private JButton formsButton;
    private JButton manufacturersButton;
    private JButton intakeButton;
    private JButton drugsButton;
    private JButton classesButton;
    private JButton salesButton;
    private JButton storagesButton;
    private JButton providersButton;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);

        initViews();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

        contentPane.registerKeyboardAction(e -> onExit(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews(){
        buttonExit.addActionListener(e -> onExit());

        usersButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.USERS));
        positionsButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.POSITIONS));
        countriesButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.COUNTRIES));
        formsButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUG_FORMS));
        manufacturersButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.MANUFACTURERS));
        drugsButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUGS));
        classesButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUG_CLASSES));
        intakeButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.NEW_INTAKES));
        salesButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.NEW_SALES));
        storagesButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.STORAGES));
        providersButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.PROVIDERS));
    }

    private void showCatalogDialog(CatalogDialog.CatalogType catalogType) {
        var catalogDialog = new CatalogDialog(catalogType);
        catalogDialog.pack();
        catalogDialog.setVisible(true);
    }


    private void onExit() {
        // add your code here if necessary
        dispose();
    }
}
