package com.niki.presentation.dialogs.map;

import com.niki.data.cache.database.datastores.*;
import com.niki.data.repository.*;
import com.niki.domain.interactors.map.intake.IntakeInteractorImpl;
import com.niki.domain.interactors.map.sale.SaleInteractorImpl;
import com.niki.presentation.dialogs.map.impl.intake.IntakePresenterImpl;
import com.niki.presentation.dialogs.map.impl.sale.SalePresenterImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MapDialog extends JDialog implements MapView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JTable table2;

    MapPresenter presenter;

    public MapDialog(DialogType type) {
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

        presenter = getPresenter(type);

    }

    private void initViews() {
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.getSelectionModel().addListSelectionListener(e -> presenter.selectionChanged(table1.getSelectedRow()));
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    @Override
    public void setTableModel(AbstractTableModel tableModel) {
        table1.setModel(tableModel);
    }

    @Override
    public void setItemTableModel(AbstractTableModel tableModel) {
        table2.setModel(tableModel);
    }

    @Override
    public void setTableCellEditor(Class aClass, TableCellEditor cellEditor) {

    }

    @Override
    public void setTableCellRenderer(Class aClass, DefaultTableCellRenderer cellRenderer) {

    }

    private MapPresenter getPresenter(DialogType type) {
        switch (type) {
            case SALE:
                return new SalePresenterImpl(this, new SaleInteractorImpl(
                        new SaleRepositorySql(new SqlSaleDataStore()),
                        new SaleItemRepositorySql(new SqlSaleItemDataStore()),
                        new UserRepositorySql(new SqlUserDataStore()),
                        new DrugRepositorySql(new SqlDrugDataStore())
                ));
            case INTAKE:
                return new IntakePresenterImpl(this, new IntakeInteractorImpl(
                        new IntakeRepositorySql(new SqlIntakeDataStore()),
                        new IntakeItemRepositorySql(new SqlIntakeItemDataStore()),
                        new ProviderRepositorySql(new SqlProviderDataStore()),
                        new DrugRepositorySql(new SqlDrugDataStore())));
        }
        return null;
    }

    public enum DialogType {
        SALE,
        INTAKE
    }
}
