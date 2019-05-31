package com.niki.presentation.dialogs.catalogs;

import com.niki.presentation.dialogs.catalog.CatalogDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CatalogsDialog extends JDialog {
    private JPanel contentPane;
    private JButton cancelButton;
    private JButton usersButton;
    private JButton positionButton;
    private JButton countryButton;
    private JButton manufacturerButton;
    private JButton providerButton;
    private JButton storageButton;
    private JButton drugButton;
    private JButton formButton;
    private JButton drugClassButton;
    private JButton indicationButton;

    public CatalogsDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Каталоги");

        initViews();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews() {
        cancelButton.addActionListener(e -> onCancel());

        usersButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.USERS));
        positionButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.POSITIONS));
        countryButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.COUNTRIES));
        formButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUG_FORMS));
        manufacturerButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.MANUFACTURERS));
        drugButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUGS));
        drugClassButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.DRUG_CLASSES));
        storageButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.STORAGES));
        providerButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.PROVIDERS));
        indicationButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.INDICATION));
    }


    private void showCatalogDialog(CatalogDialog.CatalogType catalogType) {
        var catalogDialog = new CatalogDialog(catalogType);
        catalogDialog.pack();
        catalogDialog.setVisible(true);
    }

    private void onCancel() {
        dispose();
    }

}
