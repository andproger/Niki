package com.niki.presentation.dialogs.simpleView.impl.station;

import com.niki.domain.entities.Station;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StationTableModel extends AbstractTableModel {
    private static final String[] columns = {"Название"};
    private List<Station> stations;

    StationTableModel(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public int getRowCount() {
        return stations.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = stations.get(i);

        switch (i1) {
            case 0:
                return row.getName();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
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
        var item = stations.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
