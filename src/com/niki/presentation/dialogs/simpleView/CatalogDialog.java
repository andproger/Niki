package com.niki.presentation.dialogs.simpleView;

import com.niki.data.cache.database.datastores.*;
import com.niki.data.repository.*;
import com.niki.domain.interactors.simpleView.drug.DrugInteractorImpl;
import com.niki.domain.interactors.simpleView.manufacturer.ManufacturerInteractorImpl;
import com.niki.domain.interactors.simpleView.provider.ProviderInteractorImpl;
import com.niki.domain.interactors.simpleView.admin.AdminInteractorImpl;
import com.niki.presentation.dialogs.simpleView.impl.classes.DrugClassesPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.country.CountriesPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.drug.DrugsPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.form.DrugFormsPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.indication.IndicationPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.manufacturer.ManufacturesPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.operation.OperationsPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.position.PositionsPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.provider.ProvidersPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.storage.StoragesPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.user.UsersPresenterImpl;

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

        var userAuth = new UserAuthAuthInMemoryRepository(new SqlAdminDataStore()).getCurrentUser();
        var user = new AdminRepositorySql(new SqlAdminDataStore()).get(userAuth.getUserId());
        var position = new PersonRepositorySql(new SqlPersonDataStore()).get(user.getPositionId());

        setControlsVisible(position.isAdmin());

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
            case USERS:
                presenter = new UsersPresenterImpl(this,
                        new AdminInteractorImpl(
                                new AdminRepositorySql(new SqlAdminDataStore()),
                                new ContactRepositorySql(new SqlContactDataStore()),
                                new PersonRepositorySql(new SqlPersonDataStore())
                        ));
                break;

            case DRUGS:
                presenter = new DrugsPresenterImpl(this,
                        new DrugInteractorImpl(
                                new DrugRepositorySql(new SqlDrugDataStore()),
                                new ClassRepositorySql(new SqlDrugClassDataStore()),
                                new FormRepositorySql(new SqlFormDataStore()),
                                new StorageRepositorySql(new SqlStorageDataStore()),
                                new ManufacturerRepositorySql(new SqlManufacturerDataStore()),
                                new DrugCountRepositorySql(new SqlDrugCountDataStore())));
                break;

            case STORAGES:
                presenter = new StoragesPresenterImpl(this, new StorageRepositorySql(new SqlStorageDataStore()));
                break;

            case COUNTRIES:
                presenter = new CountriesPresenterImpl(this, new CountryRepositorySql(new SqlCountryDataStore()));
                break;

            case POSITIONS:
                presenter = new PositionsPresenterImpl(this,
                        new PersonRepositorySql(
                                new SqlPersonDataStore()
                        ));
                break;

            case PROVIDERS:
                presenter = new ProvidersPresenterImpl(
                        this,
                        new ProviderInteractorImpl(
                                new ProviderRepositorySql(new SqlProviderDataStore()),
                                new ContactRepositorySql(new SqlContactDataStore())
                        )
                );
                break;

            case DRUG_CLASSES:
                presenter = new DrugClassesPresenterImpl(this, new ClassRepositorySql(new SqlDrugClassDataStore()));
                break;

            case DRUG_FORMS:
                presenter = new DrugFormsPresenterImpl(this, new FormRepositorySql(new SqlFormDataStore()));
                break;

            case MANUFACTURERS:
                presenter = new ManufacturesPresenterImpl(this, new ManufacturerInteractorImpl(
                        new ManufacturerRepositorySql(new SqlManufacturerDataStore()),
                        new ContactRepositorySql(new SqlContactDataStore()),
                        new CountryRepositorySql(new SqlCountryDataStore())
                ));
                break;
            case INDICATION:
                presenter = new IndicationPresenterImpl(this, new IndicationRepositorySql(new SqlIndicationDataStore()));
                break;
            case OPERATIONS:
                presenter = new OperationsPresenterImpl(this, new OperationRepositorySql(new SqlOperationDataStore()));
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
        STORAGES,
        PROVIDERS,
        INDICATION,
        OPERATIONS
    }
}
