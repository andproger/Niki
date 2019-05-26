package com.niki.presentation.dialogs.main;

import com.niki.presentation.dialogs.catalog.CatalogDialog;
import com.niki.presentation.dialogs.catalogs.CatalogsDialog;
import com.niki.presentation.dialogs.map.MapDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainDialog extends JDialog {
    private JPanel contentPane;

    private JButton buttonExit;
    private JButton intakeButton;
    private JButton salesButton;
    private JButton intakesButton;
    private JButton saleButton;
    private JButton catalogsButton;

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

    private void initViews() {
        buttonExit.addActionListener(e -> onExit());

        intakeButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.NEW_INTAKES));
        salesButton.addActionListener(actionEvent -> showCatalogDialog(CatalogDialog.CatalogType.NEW_SALES));
        intakesButton.addActionListener(actionEvent -> showMapDialog(MapDialog.DialogType.INTAKE));
        saleButton.addActionListener(actionEvent -> showMapDialog(MapDialog.DialogType.SALE));
        catalogsButton.addActionListener(actionEvent -> showCatalogsDialog());
    }

    private void showCatalogsDialog() {
        var catalogsDialog = new CatalogsDialog();
        catalogsDialog.pack();
        catalogsDialog.setVisible(true);
    }

    private void showCatalogDialog(CatalogDialog.CatalogType catalogType) {
        var catalogDialog = new CatalogDialog(catalogType);
        catalogDialog.pack();
        catalogDialog.setVisible(true);
    }

    private void showMapDialog(MapDialog.DialogType type) {
        var mapDialog = new MapDialog(type);
        mapDialog.pack();
        mapDialog.setVisible(true);
    }


    private void onExit() {
        // add your code here if necessary
        dispose();
    }
}
