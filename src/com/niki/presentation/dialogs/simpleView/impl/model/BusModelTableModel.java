package com.niki.presentation.dialogs.simpleView.impl.model;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.interactors.simpleView.bus.BusContract;
import com.niki.domain.interactors.simpleView.model.BusModelContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BusModelTableModel extends AbstractTableModel {
    private static final String[] columns = {"Название", "Запас хода", "Сидения"};
    private List<BusModelContract> items;

    BusModelTableModel(List<BusModelContract> items) {
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
                return row.getBrand();
            case 2:
                return row.getPowerReserve();
            case 3:
                return row.getSeats();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return BusBrand.class;
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
                item.setBrand((BusBrand) aValue);
                break;
            case 2:
                item.setPowerReserve((Integer) aValue);
                break;
            case 3:
                item.setSeats((Integer) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
