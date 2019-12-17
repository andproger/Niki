package com.niki.presentation.dialogs.simpleView.impl.driver;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.driver.DriverContract;
import com.niki.domain.interactors.simpleView.driver.DriverInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.CellEditor;

import java.util.List;

public class DriverPresenterImpl extends BaseCatalogPresenter {
    private final DriverInteractor driverInteractor;

    private DriverTableModel tableModel;
    private List<DriverContract> driverContracts;

    public DriverPresenterImpl(CatalogView view, DriverInteractor driverInteractor) {
        super(view);
        this.driverInteractor = driverInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.driverContracts = driverInteractor.get();
        this.tableModel = new DriverTableModel(driverContracts);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Person.class, new CellEditor<>(driverInteractor.getPersons()));
    }

    @Override
    public void onSaveClicked() {
        driverInteractor.save(driverContracts);
    }

    @Override
    public void onAddClicked() {
        driverContracts.add(new DriverContract(0, "", null));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.driverContracts.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
