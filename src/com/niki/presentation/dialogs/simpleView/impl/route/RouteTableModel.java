package com.niki.presentation.dialogs.simpleView.impl.route;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.Station;
import com.niki.domain.interactors.simpleView.model.BusModelContract;
import com.niki.domain.interactors.simpleView.route.RouteContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RouteTableModel extends AbstractTableModel {
    private static final String[] columns = {"Название", "Пункт отправления", "Пункт прибытия", "Дистанция"};
    private List<RouteContract> items;

    RouteTableModel(List<RouteContract> items) {
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
                return row.getName();
            case 1:
                return row.getFromStation();
            case 2:
                return row.getToStation();
            case 3:
                return row.getDistance();
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
                return Station.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
            case 1:
                item.setFromStation((Station) aValue);
                break;
            case 2:
                item.setToStation((Station) aValue);
                break;
            case 3:
                item.setDistance(Integer.parseInt((String)aValue));
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
