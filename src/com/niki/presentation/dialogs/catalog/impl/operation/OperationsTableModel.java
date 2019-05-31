package com.niki.presentation.dialogs.catalog.impl.operation;

import com.niki.domain.entities.Operation;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OperationsTableModel extends AbstractTableModel {
    private static final String[] columns = {"Дата", "Событие"};
    private List<Operation> operations;

    public OperationsTableModel(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public int getRowCount() {
        return operations.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = operations.get(i);

        switch (i1) {
            case 0:
                return row.getDateTime().toString();
            case 1:
                return row.getDescription();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
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
        return false;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = operations.get(rowIndex);

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
