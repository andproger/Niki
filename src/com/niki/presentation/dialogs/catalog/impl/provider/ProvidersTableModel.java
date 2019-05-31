package com.niki.presentation.dialogs.catalog.impl.provider;

import com.niki.domain.entities.Provider;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProvidersTableModel extends AbstractTableModel {
    private static final String[] columns = {"Поставшик", "Адрес", "Email", "Телефон"};
    private List<Provider> providers;

    public ProvidersTableModel(List<Provider> providers) {
        this.providers = providers;
    }

    @Override
    public int getRowCount() {
        return providers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = providers.get(i);

        switch (i1) {
            case 0:
                return row.getName();
            case 1:
                return row.getAddress();
            case 2:
                return row.getEmail();
            case 3:
                return row.getNumber();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
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
        return columnIndex != 0;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = providers.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setName((String) aValue);
                break;
            case 2:
                item.setAddress((String) aValue);
                break;
            case 3:
                item.setEmail((String) aValue);
                break;
            case 4:
                item.setNumber((String) aValue);
                break;

        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
