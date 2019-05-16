package com.niki.presentation.dialogs.catalog;

import com.niki.data.repository.*;
import com.niki.domain.interactors.catalog.drug.DrugInteractorImpl;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerInteractorImpl;
import com.niki.presentation.dialogs.catalog.impl.classes.DrugClassesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.country.CountriesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.drug.DrugsPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.form.DrugFormsPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.intake.NewIntakesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.manufacturer.ManufacturesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.position.PositionsPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.provider.ProvidersPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.sale.NewSalesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.storage.StoragesPresenterImpl;
import com.niki.presentation.dialogs.catalog.impl.user.UsersPresenterImpl;

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

        setupPresenter(type);
        initViews();

        getRootPane().setDefaultButton(buttonSave);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews() {
        buttonSave.addActionListener(e -> presenter.onSaveClicked());
        buttonCancel.addActionListener(e -> onCancel());
        buttonAdd.addActionListener(e -> presenter.onAddClicked());
        buttonDelete.addActionListener(e -> presenter.onDeleteClicked(table1.getSelectedRows()));
    }

    private void onCancel() {
        // buttonAdd your code here if necessary
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

    private void setupPresenter(CatalogType type) {
        switch (type) {
            case USERS:
                presenter = new UsersPresenterImpl(this);
                break;

            case DRUGS:
                presenter = new DrugsPresenterImpl(this,
                        new DrugInteractorImpl(
                                new DrugRepositorySql(),
                                new ClassRepositorySql(),
                                new FormRepositorySql(),
                                new StorageRepositorySql(),
                                new ManufacturerRepositorySql()
                        ));
                break;

            case STORAGES:
                presenter = new StoragesPresenterImpl(this, new StorageRepositorySql());
                break;

            case COUNTRIES:
                presenter = new CountriesPresenterImpl(this, new CountryRepositorySql());
                break;

            case NEW_SALES:
                presenter = new NewSalesPresenterImpl(this);
                break;

            case POSITIONS:
                presenter = new PositionsPresenterImpl(this);
                break;

            case PROVIDERS:
                presenter = new ProvidersPresenterImpl(this);
                break;

            case DRUG_CLASSES:
                presenter = new DrugClassesPresenterImpl(this, new ClassRepositorySql());
                break;

            case DRUG_FORMS:
                presenter = new DrugFormsPresenterImpl(this, new FormRepositorySql());
                break;

            case NEW_INTAKES:
                presenter = new NewIntakesPresenterImpl(this);
                break;

            case MANUFACTURERS:
                presenter = new ManufacturesPresenterImpl(this, new ManufacturerInteractorImpl(new ManufacturerRepositorySql(), new CountryRepositorySql()));
                break;

            default:
                throw new IllegalStateException();
        }
    }

    public enum CatalogType {
        USERS,
        POSITIONS,
        COUNTRIES,
        MANUFACTURERS,
        DRUGS,
        DRUG_FORMS,
        DRUG_CLASSES,
        NEW_SALES,
        NEW_INTAKES,
        STORAGES,
        PROVIDERS
    }
}
