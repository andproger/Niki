package com.niki.presentation.dialogs.catalogs;

import com.niki.presentation.dialogs.simpleView.CatalogDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CatalogsDialog extends JDialog {
    private JPanel contentPane;
    private JButton cancelButton;
    private JButton adminButton;
    private JButton brandButton;
    private JButton busButton;
    private JButton personsButton;

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

        adminButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.ADMIN));
        brandButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.BRAND));
        busButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.BUS));
        personsButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.PERSON));
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
