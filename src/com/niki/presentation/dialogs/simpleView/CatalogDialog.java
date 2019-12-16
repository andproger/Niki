package com.niki.presentation.dialogs.simpleView;

import com.niki.data.cache.database.datastores.*;
import com.niki.data.repository.*;
import com.niki.domain.interactors.simpleView.admin.AdminInteractorImpl;
import com.niki.domain.interactors.simpleView.bus.BusInteractorImpl;
import com.niki.domain.interactors.simpleView.person.PersonInteractorImpl;
import com.niki.presentation.dialogs.simpleView.impl.admin.AdminPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.bus.BusPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.person.PersonPresenterImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CatalogDialog extends JDialog implements CatalogView {
    private JPanel contentPane;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JTable table1;

    private CatalogPresenter presenter;

    public CatalogDialog(CatalogType type) {
        setContentPane(contentPane);
        setModal(true);

        getRootPane().setDefaultButton(buttonSave);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        setupPresenter(type);
        initViews();

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews() {
        buttonCancel.addActionListener(e -> onCancel());

        buttonSave.addActionListener(e -> presenter.onSaveClicked());
        buttonAdd.addActionListener(e -> presenter.onAddClicked());
        buttonDelete.addActionListener(e -> {
            var viewRows = table1.getSelectedRows();
            var rows = new int[viewRows.length];

            for (int i = 0; i < viewRows.length; i++)
                rows[i] = table1.convertRowIndexToModel(viewRows[i]);

            presenter.onDeleteClicked(rows);
        });

        table1.setAutoCreateRowSorter(true);
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
    public void setTableCellRenderer(Class aClass, DefaultTableCellRenderer cellRenderer) {
        table1.setDefaultRenderer(aClass, cellRenderer);
    }

    @Override
    public void setControlsVisible(boolean isVisible) {
        buttonSave.setVisible(isVisible);
        buttonAdd.setVisible(isVisible);
        buttonDelete.setVisible(isVisible);
    }

    private void setupPresenter(CatalogType type) {
        switch (type) {
            case ADMIN:
                presenter = new AdminPresenterImpl(this,
                        new AdminInteractorImpl(
                                new AdminRepositorySql(new SqlAdminDataStore()),
                                new PersonRepositorySql(new SqlPersonDataStore())
                        ));
                break;
            case BUS:
                presenter = new BusPresenterImpl(this,
                        new BusInteractorImpl(
                                new BusRepositorySql(new SqlBusDataStore()),
                                new BusColorRepositorySql(new SqlBusColorDataStore()),
                                new BusModelRepositorySql(new SqlBusModelDataStore())
                        ));
        case PERSON:
                presenter = new PersonPresenterImpl(this,
                        new PersonInteractorImpl(new PersonRepositorySql(new SqlPersonDataStore())));
                break;

            default:
                throw new IllegalStateException();
        }
    }

    public enum CatalogType {
        ADMIN,
        BRAND,
        BUS,
        PERSON,
    }
}
