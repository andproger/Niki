package com.niki.presentation.dialogs.catalog.impl.position;

import com.niki.domain.entities.Position;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PositionsTableModel extends AbstractTableModel {
    private static final String[] columns = {"Должность", "З/П", "Администратор"};
    private List<Position> positions;

    public PositionsTableModel(List<Position> positions) {
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
                return row.getName();
            case 1:
                return row.getSalary();
            case 2:
                return row.isAdmin();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Boolean.class;
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
        var item = positions.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
            case 1:
                item.setSalary((Double) aValue);
                break;
            case 2:
                item.setAdmin((Boolean) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
