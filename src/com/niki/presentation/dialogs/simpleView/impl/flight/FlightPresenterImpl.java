package com.niki.presentation.dialogs.simpleView.impl.flight;

import com.github.lgooddatepicker.tableeditors.DateTimeTableEditor;
import com.niki.domain.entities.Bus;
import com.niki.domain.entities.Driver;
import com.niki.domain.entities.Route;
import com.niki.domain.interactors.simpleView.flight.FlightContract;
import com.niki.domain.interactors.simpleView.flight.FlightInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;
import com.niki.presentation.dialogs.simpleView.ComboboxCellEditor;
import com.niki.presentation.dialogs.simpleView.SelectDriversCellEditor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightPresenterImpl extends BaseCatalogPresenter {
    private final FlightInteractor flightInteractor;

    private FlightTableModel tableModel;
    private List<FlightContract> items;

    public FlightPresenterImpl(CatalogView view, FlightInteractor flightInteractor) {
        super(view);
        this.flightInteractor = flightInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = flightInteractor.get();
        this.tableModel = new FlightTableModel(items);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Bus.class, new ComboboxCellEditor<>(flightInteractor.getBuses()));
        view.setTableCellEditor(Route.class, new ComboboxCellEditor<>(flightInteractor.getRoutes()));
        view.setTableCellEditor(List.class, new SelectDriversCellEditor());
        view.setTableCellEditor(LocalDateTime.class, new DateTimeTableEditor());
        view.setTableCellRenderer(LocalDateTime.class, new DateTimeTableEditor());
    }

    @Override
    public void onSaveClicked() {
        flightInteractor.save(items);
    }

    @Override
    public void onAddClicked() {

        items.add(new FlightContract(0, null, null, 0, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now()));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
