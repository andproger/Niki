package com.niki.presentation.dialogs.simpleView.impl.color;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BusColorTableModel extends AbstractTableModel {
    private static final String[] columns = {"Цвет"};
    private List<BusColor> items;

    BusColorTableModel(List<BusColor> items) {
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
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
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

        if (columnIndex == 0) {
            item.setName((String) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
