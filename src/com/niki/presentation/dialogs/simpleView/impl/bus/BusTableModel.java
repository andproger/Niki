package com.niki.presentation.dialogs.simpleView.impl.bus;

import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.bus.BusContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BusTableModel extends AbstractTableModel {
    private static final String[] columns = {"Цвет", "Модель", "Номер"};
    private List<BusContract> items;

    BusTableModel(List<BusContract> items) {
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
                return row.getColor();
            case 1:
                return row.getModel();
            case 2:
                return row.getNumber();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return BusColor.class;
            case 1:
                return BusModel.class;
            case 2:
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
        var item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setColor((BusColor) aValue);
                break;
            case 1:
                item.setModel((BusModel) aValue);
                break;
            case 2:
                item.setNumber((String)aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
