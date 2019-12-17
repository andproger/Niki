package com.niki.presentation.dialogs.simpleView.impl.admin;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.admin.AdminContract;
import com.niki.domain.interactors.simpleView.admin.AdminInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.ComboboxCellEditor;
import com.niki.presentation.dialogs.simpleView.impl.admin.create.CreateAdminDialog;

import java.util.List;

public class AdminPresenterImpl extends BaseCatalogPresenter {
    private final AdminInteractor adminInteractor;

    private AdminTableModel tableModel;
    private List<AdminContract> adminContracts;

    public AdminPresenterImpl(CatalogView view, AdminInteractor adminInteractor) {
        super(view);
        this.adminInteractor = adminInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.adminContracts = adminInteractor.get();
        this.tableModel = new AdminTableModel(adminContracts);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Person.class, new ComboboxCellEditor<>(adminInteractor.getPersons()));
    }

    @Override
    public void onSaveClicked() {
        adminInteractor.save(adminContracts);
    }

    @Override
    public void onAddClicked() {
        var createUserDialog = new CreateAdminDialog();
        createUserDialog.pack();
        createUserDialog.setVisible(true);
        var userContract = createUserDialog.getAdminContract();

        if (userContract != null) {
            adminContracts.add(userContract);
            tableModel.fireTableDataChanged();
        }
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.adminContracts.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
