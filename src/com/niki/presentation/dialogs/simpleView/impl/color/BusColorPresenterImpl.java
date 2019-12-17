package com.niki.presentation.dialogs.simpleView.impl.color;

import com.niki.domain.entities.BusColor;
import com.niki.domain.interactors.simpleView.color.BusColorInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;

import java.util.List;

public class BusColorPresenterImpl extends BaseCatalogPresenter {
    private final BusColorInteractor busColorInteractor;

    private BusColorTableModel tableModel;
    private List<BusColor> items;

    public BusColorPresenterImpl(CatalogView view, BusColorInteractor busColorInteractor) {
        super(view);
        this.busColorInteractor = busColorInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = busColorInteractor.get();
        this.tableModel = new BusColorTableModel(items);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        busColorInteractor.save(items);
    }

    @Override
    public void onAddClicked() {
        items.add(new BusColor(0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
