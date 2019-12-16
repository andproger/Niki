package com.niki.presentation.dialogs.simpleView.impl.brand;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.interactors.simpleView.busBrand.BusBrandInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;

import java.util.List;

public class BusModelPresenterImpl extends BaseCatalogPresenter {
    private final BusBrandInteractor busBrandInteractor;

    private BusModelTableModel tableModel;
    private List<BusBrand> items;

    public BusModelPresenterImpl(CatalogView view, BusBrandInteractor busBrandInteractor) {
        super(view);
        this.busBrandInteractor = busBrandInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = busBrandInteractor.get();
        this.tableModel = new BusModelTableModel(items);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        busBrandInteractor.save(items);
    }

    @Override
    public void onAddClicked() {
        items.add(new BusBrand(0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
