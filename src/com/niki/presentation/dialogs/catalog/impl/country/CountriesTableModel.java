package com.niki.presentation.dialogs.catalog.impl.country;


import com.niki.domain.entities.Country;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CountriesTableModel extends AbstractTableModel {
    private static final String[] columns = {"Страна", "Код страны"};
    private List<Country> countries;

    public CountriesTableModel(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public int getRowCount() {
        return countries.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = countries.get(i);

        switch (i1) {
            case 0:
                return row.getName();
            case 1:
                return row.getCode();
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
        return true;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = countries.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
            case 1:
                item.setCode((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
