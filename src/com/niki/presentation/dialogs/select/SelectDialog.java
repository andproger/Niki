package com.niki.presentation.dialogs.select;

import com.niki.data.cache.database.datastores.SqlDriverDataStore;
import com.niki.data.cache.database.datastores.SqlPersonDataStore;
import com.niki.data.repository.DriverRepositorySql;
import com.niki.data.repository.PersonRepositorySql;
import com.niki.domain.interactors.simpleView.driver.DriverInteractorImpl;
import com.niki.presentation.dialogs.select.impl.driver.DriverPresenterImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class SelectDialog extends JDialog implements SelectView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private int[] rows;

    private final SelectPresenter presenter;

    public List GetSelected() {
        return presenter.getSelectedItems(rows);
    }

    public SelectDialog() {
        this.presenter = new DriverPresenterImpl(this, new DriverInteractorImpl(
                new DriverRepositorySql(new SqlDriverDataStore()),
                new PersonRepositorySql(new SqlPersonDataStore())
        ));

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            presenter.onOkClicked();
            onOK();
        });

        buttonCancel.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        var viewRows = table1.getSelectedRows();
        rows = new int[viewRows.length];

        for (int i = 0; i < viewRows.length; i++)
            rows[i] = table1.convertRowIndexToModel(viewRows[i]);

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
    public void setTableCellEditor(Class aClass, TableCellEditor cellEditor) {
        table1.setDefaultEditor(aClass, cellEditor);
    }

    @Override
    public void setTableCellRenderer(Class aClass, TableCellRenderer cellRenderer) {
        table1.setDefaultRenderer(aClass, cellRenderer);
    }

}
