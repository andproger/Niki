package com.niki.presentation.dialogs.select.impl.driver;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.driver.DriverContract;
import com.niki.domain.interactors.simpleView.driver.DriverInteractor;
import com.niki.presentation.dialogs.select.BaseSelectPresenter;
import com.niki.presentation.dialogs.select.SelectView;
import com.niki.presentation.dialogs.select.ComboboxCellEditor;
import com.niki.presentation.dialogs.simpleView.impl.driver.DriverTableModel;

import java.util.ArrayList;
import java.util.List;

public class DriverPresenterImpl extends BaseSelectPresenter {
    private final DriverInteractor driverInteractor;

    private DriverTableModel tableModel;
    private List<DriverContract> driverContracts;

    public DriverPresenterImpl(SelectView view, DriverInteractor driverInteractor) {
        super(view);
        this.driverInteractor = driverInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.driverContracts = driverInteractor.get();
        this.tableModel = new DriverTableModel(driverContracts);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Person.class, new ComboboxCellEditor<>(driverInteractor.getPersons()));
    }

    @Override
    public void onOkClicked() {

    }

    @Override
    public List getSelectedItems(int[] rows) {
        var list = new ArrayList<DriverContract>();
        for(var row : rows)
            list.add(driverContracts.get(row));

        return list;
    }
}
