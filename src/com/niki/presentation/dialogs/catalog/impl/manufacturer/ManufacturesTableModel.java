package com.niki.presentation.dialogs.catalog.impl.manufacturer;

import com.niki.domain.entities.Country;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ManufacturesTableModel extends AbstractTableModel {
    private static final String[] columns = {"Имя", "Страна", "Адрес", "Email", "Номер", "Сайт"};
    private List<ManufacturerContract> manufacturers;

    ManufacturesTableModel(List<ManufacturerContract> manufacturers) {
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
                return row.getName();
            case 1:
                return row.getCountry();
            case 2:
                return row.getContact().getAddress();
            case 3:
                return row.getContact().getEmail();
            case 4:
                return row.getContact().getPhone();
            case 5:
                return row.getContact().getSite();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return String.class;
            case 1:
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
        return true;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = manufacturers.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
            case 1:
                item.setCountry((Country) aValue);
                break;
            case 2:
                item.getContact().setAddress((String) aValue);
                break;
            case 3:
                item.getContact().setEmail((String) aValue);
                break;
            case 4:
                item.getContact().setPhone((String) aValue);
                break;
            case 5:
                item.getContact().setSite((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
