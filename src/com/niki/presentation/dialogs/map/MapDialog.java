package com.niki.presentation.dialogs.map;

import com.niki.data.cache.database.datastores.SqlDrugDataStore;
import com.niki.data.cache.database.datastores.SqlIntakeDataStore;
import com.niki.data.cache.database.datastores.SqlIntakeItemDataStore;
import com.niki.data.cache.database.datastores.SqlProviderDataStore;
import com.niki.data.repository.DrugRepositorySql;
import com.niki.data.repository.IntakeItemRepositorySql;
import com.niki.data.repository.IntakeRepositorySql;
import com.niki.data.repository.ProviderRepositorySql;
import com.niki.domain.interactors.map.intake.IntakeInteractorImpl;
import com.niki.presentation.dialogs.map.impl.intake.IntakePresenterImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JButton deleteButton;
    private JButton deleteItemButton;

    IntakePresenterImpl presenter;

    public MapDialog() {
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

        presenter = new IntakePresenterImpl(this, new IntakeInteractorImpl(
                new IntakeRepositorySql(new SqlIntakeDataStore()),
                new IntakeItemRepositorySql(new SqlIntakeItemDataStore()),
                new ProviderRepositorySql(new SqlProviderDataStore()),
                new DrugRepositorySql(new SqlDrugDataStore())));

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
}
