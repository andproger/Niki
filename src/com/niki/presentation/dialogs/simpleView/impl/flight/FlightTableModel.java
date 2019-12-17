package com.niki.presentation.dialogs.simpleView.impl.flight;

import com.niki.domain.entities.Driver;
import com.niki.domain.entities.Flight;
import com.niki.domain.entities.Route;
import com.niki.domain.entities.Station;
import com.niki.domain.interactors.simpleView.flight.FlightContract;
import com.niki.domain.interactors.simpleView.route.RouteContract;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.*;

public class FlightTableModel extends AbstractTableModel {
    private static final String[] columns = {"Маршрут",  "Время отправления", "Время прибытия", "Дистанция"};
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
                return row.getDepartureTime();
            case 2:
                return row.getArrivalTime();
            case 3:
                return row.getRoute().getDistance();
            case 4:
                return Arrays.toString(row.getDrivers().toArray());
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
            case 2:
                return Date.class;
            case 4:
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
        return columnIndex != 3 && columnIndex != 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setRoute((Route) aValue);
                break;
            case 1:
                item.setDepartureTime((Date) aValue);
                break;
            case 2:
                item.setArrivalTime((Date) aValue);
                break;
            case 4:
                item.setDrivers((ArrayList<Driver>) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
