package com.niki.presentation.dialogs.catalog.impl.user;

import com.niki.domain.entities.Position;
import com.niki.domain.interactors.catalog.user.UserContract;
import com.niki.domain.interactors.catalog.user.UserInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;
import com.niki.presentation.dialogs.catalog.impl.position.PositionsTableModel;

import java.util.ArrayList;

public class UsersPresenterImpl extends BaseCatalogPresenter {
    private final UserInteractor userInteractor;

    private UsersTableModel tableModel;
    private ArrayList<UserContract> userContracts;

    public UsersPresenterImpl(CatalogView view, UserInteractor userInteractor) {
        super(view);
        this.userInteractor = userInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.userContracts = userInteractor.getUsers();
        this.tableModel = new UsersTableModel(userContracts);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Position.class, new CellEditor<>(userInteractor.getPositions()));
    }

    @Override
    public void onSaveClicked() {
        userInteractor.saveUsers(userContracts);
    }

    @Override
    public void onAddClicked() {
        userContracts.add(new UserContract(0, "", "", "", "", null));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.userContracts.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
