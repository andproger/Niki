package com.niki.presentation.dialogs.simpleView.impl.flight;

import com.niki.domain.entities.*;
import com.niki.domain.interactors.simpleView.flight.FlightContract;
import com.niki.domain.interactors.simpleView.route.RouteContract;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class FlightTableModel extends AbstractTableModel {
    private static final String[] columns = {"Маршрут", "Автобус", "Время отправления", "Время прибытия", "Дистанция", "Водители"};
    private List<FlightContract> items;

    FlightTableModel(List<FlightContract> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = items.get(i);

        switch (i1) {
            case 0:
                return row.getRoute();
            case 1:
                return row.getBus();
            case 2:
                return row.getDepartureTime();
            case 3:
                return row.getArrivalTime();
            case 4:
                return row.getRoute() != null? row.getRoute().getDistance() : 0;
            case 5:
                return row.getDrivers();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Route.class;
            case 1:
                return Bus.class;
            case 2:
            case 3:
                return LocalDateTime.class;
            case 5:
                return ArrayList.class;

        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setRoute((Route) aValue);
                break;
            case 1:
                item.setBus((Bus) aValue);
                break;
            case 2:
                item.setDepartureTime((LocalDateTime) aValue);
                break;
            case 3:
                item.setArrivalTime((LocalDateTime) aValue);
                break;
            case 5:
                item.setDrivers((ArrayList<Driver>) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
