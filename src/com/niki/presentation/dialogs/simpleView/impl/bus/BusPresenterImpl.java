package com.niki.presentation.dialogs.simpleView.impl.bus;

import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.interactors.simpleView.bus.BusContract;
import com.niki.domain.interactors.simpleView.bus.BusInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.CellEditor;

import java.util.List;

public class BusPresenterImpl extends BaseCatalogPresenter {
    private final BusInteractor busInteractor;

    private BusTableModel tableModel;
    private List<BusContract> items;

    public BusPresenterImpl(CatalogView view, BusInteractor busInteractor) {
        super(view);
        this.busInteractor = busInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = busInteractor.get();
        this.tableModel = new BusTableModel(items);
        view.setTableModel(tableModel);
        view.setTableCellEditor(BusColor.class, new CellEditor<>(busInteractor.getColors()));
        view.setTableCellEditor(BusModel.class, new CellEditor<>(busInteractor.getModels()));
    }

    @Override
    public void onSaveClicked() {
        busInteractor.save(items);
    }

    @Override
    public void onAddClicked() {

        items.add(new BusContract(0, null, null, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
