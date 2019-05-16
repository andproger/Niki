package com.niki.presentation.dialogs.catalog.impl.storage;

import com.niki.domain.entities.Storage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StoragesTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Хранилище"};
    private ArrayList<Storage> storages;

    public StoragesTableModel(ArrayList<Storage> storages) {
        this.storages = storages;
    }

    @Override
    public int getRowCount() {
        return storages.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = storages.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getDescription();
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
        }
        return super.getColumnClass(columnIndex);
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = storages.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setDescription((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
