package com.niki.presentation.dialogs.main;

import com.niki.data.cache.database.datastores.SqlPositionDataStore;
import com.niki.data.cache.database.datastores.SqlUserDataStore;
import com.niki.data.repository.PositionRepositorySql;
import com.niki.data.repository.UserAuthAuthInMemoryRepository;
import com.niki.data.repository.UserRepositorySql;
import com.niki.presentation.dialogs.catalog.CatalogDialog;
import com.niki.presentation.dialogs.catalogs.CatalogsDialog;
import com.niki.presentation.dialogs.intake.NewIntakeDialog;
import com.niki.presentation.dialogs.map.MapDialog;
import com.niki.presentation.dialogs.sale.NewSaleDialog;

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
        setTitle("Главное меню");
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

        intakeButton.addActionListener(actionEvent -> showDialog(new NewIntakeDialog()));
        salesButton.addActionListener(actionEvent -> showDialog(new NewSaleDialog()));
        intakesButton.addActionListener(actionEvent -> showMapDialog(MapDialog.DialogType.INTAKE));
        saleButton.addActionListener(actionEvent -> showMapDialog(MapDialog.DialogType.SALE));
        catalogsButton.addActionListener(actionEvent -> showDialog(new CatalogsDialog()));
    }

    private void showMapDialog(MapDialog.DialogType type) {
        var mapDialog = new MapDialog(type);
        showDialog(mapDialog);
    }


    private void showDialog(JDialog dialog){
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onExit() {
        dispose();
    }
}
