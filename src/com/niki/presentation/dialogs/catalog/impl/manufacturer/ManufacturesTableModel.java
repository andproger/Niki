package com.niki.presentation.dialogs.catalog.impl.manufacturer;

import com.niki.domain.entities.Country;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerContract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ManufacturesTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Имя", "Страна", "Адрес"};
    private ArrayList<ManufacturerContract> manufacturers;

    public ManufacturesTableModel(ArrayList<ManufacturerContract> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public int getRowCount() {
        return manufacturers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = manufacturers.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getName();
            case 2:
                return row.getCountry();
            case 3:
                return row.getAddress();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 3:
                return String.class;
            case 2:
                return Country.class;
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
        var item = manufacturers.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setName((String) aValue);
                break;
            case 2:
                item.setCountry((Country) aValue);
                break;
            case 3:
                item.setAddress((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
