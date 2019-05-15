package com.niki.presentation.dialogs.catalog.impl.manufacturer;

import com.niki.domain.entities.Country;
import com.niki.domain.entities.Manufacturer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManufacturesTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Имя", "Страна", "Адрес"};
    private ArrayList<Manufacturer> manufacturers;
    private ArrayList<Country> countries;

    public ManufacturesTableModel(ArrayList<Manufacturer> manufacturers, ArrayList<Country> countries) {
        this.manufacturers = manufacturers;
        this.countries = countries;
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
            case 2: {
                var country = new Country(row.getCountryId(), "", "");
                var index = Collections.binarySearch(countries, country, Comparator.comparingInt(Country::getId));
                return index >= 0 ? countries.get(index) : null;
            }
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
                item.setCountryId(((Country) aValue).getId());
                break;
            case 3:
                item.setAddress((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
