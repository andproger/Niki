package com.niki.presentation.dialogs.simpleView.impl.station;

import com.niki.domain.entities.Station;
import com.niki.domain.interactors.simpleView.station.StationInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;

import java.util.List;

public class StationPresenterImpl extends BaseCatalogPresenter {
    private final StationInteractor stationInteractor;

    private StationTableModel tableModel;
    private List<Station> items;

    public StationPresenterImpl(CatalogView view, StationInteractor stationInteractor) {
        super(view);
        this.stationInteractor = stationInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = stationInteractor.get();
        this.tableModel = new StationTableModel(items);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        stationInteractor.save(items);
    }

    @Override
    public void onAddClicked() {
        items.add(new Station(0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
