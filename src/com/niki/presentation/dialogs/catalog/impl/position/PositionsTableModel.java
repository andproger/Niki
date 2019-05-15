package com.niki.presentation.dialogs.catalog.impl.position;

import com.niki.domain.entities.Position;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PositionsTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Должность", "З/П"};
    private ArrayList<Position> positions;

    public PositionsTableModel(ArrayList<Position> positions) {
        this.positions = positions;
    }

    @Override
    public int getRowCount() {
        return positions.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = positions.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getName();
            case 2:
                return row.getSalary();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
        }
        return super.getColumnClass(columnIndex);
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = positions.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setName((String) aValue);
                break;
            case 2:
                item.setSalary((Double) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
