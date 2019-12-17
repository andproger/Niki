package com.niki.presentation.dialogs.simpleView.impl.flight;

import com.niki.domain.entities.Station;
import com.niki.domain.interactors.simpleView.route.RouteContract;
import com.niki.domain.interactors.simpleView.route.RouteInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.CellEditor;

import java.util.List;

public class RoutePresenterImpl extends BaseCatalogPresenter {
    private final RouteInteractor routeInteractor;

    private FlightTableModel tableModel;
    private List<RouteContract> items;

    public RoutePresenterImpl(CatalogView view, RouteInteractor routeInteractor) {
        super(view);
        this.routeInteractor = routeInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = routeInteractor.get();
        this.tableModel = new FlightTableModel(items);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Station.class, new CellEditor<>(routeInteractor.getStations()));
    }

    @Override
    public void onSaveClicked() {
        routeInteractor.save(items);
    }

    @Override
    public void onAddClicked() {

        items.add(new RouteContract(0, "", null, null, 0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
