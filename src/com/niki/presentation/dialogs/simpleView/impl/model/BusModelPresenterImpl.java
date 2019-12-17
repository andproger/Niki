package com.niki.presentation.dialogs.simpleView.impl.model;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.interactors.simpleView.model.BusModelContract;
import com.niki.domain.interactors.simpleView.model.BusModelInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.ComboboxCellEditor;

import java.util.List;

public class BusModelPresenterImpl extends BaseCatalogPresenter {
    private final BusModelInteractor busModelInteractor;

    private BusModelTableModel tableModel;
    private List<BusModelContract> items;

    public BusModelPresenterImpl(CatalogView view, BusModelInteractor busModelInteractor) {
        super(view);
        this.busModelInteractor = busModelInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = busModelInteractor.get();
        this.tableModel = new BusModelTableModel(items);
        view.setTableModel(tableModel);
        view.setTableCellEditor(BusBrand.class, new ComboboxCellEditor<>(busModelInteractor.getBrands()));
    }

    @Override
    public void onSaveClicked() {
        busModelInteractor.save(items);
    }

    @Override
    public void onAddClicked() {

        items.add(new BusModelContract(0, null, "", 0, 0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
