package com.niki.presentation.dialogs.catalog.impl.drug;

import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;
import com.niki.domain.interactors.catalog.drug.DrugContract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DrugsTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Имя", "Описание", "Цена", "Производитель", "Хранилище", "Форма"};
    private ArrayList<DrugContract> drugs;

    public DrugsTableModel(ArrayList<DrugContract> drugs) {
        this.drugs = drugs;
    }

    @Override
    public int getRowCount() {
        return drugs.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = drugs.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getName();
            case 2:
                return row.getDescription();
            case 3:
                return row.getCost();
            case 4: {
                return row.getManufacturer();
            }
            case 5: {
                return row.getStorage();
            }
            case 6: {
                return row.getForm();
            }
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return Manufacturer.class;
            case 5:
                return Storage.class;
            case 6:
                return Form.class;
        }
        return super.getColumnClass(columnIndex);
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0 && columnIndex <= 6;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = drugs.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setName((String) aValue);
                break;
            case 2:
                item.setDescription((String) aValue);
                break;
            case 3:
                item.setCost((Double) aValue);
                break;
            case 4:
                item.setManufacturer((Manufacturer) aValue);
                break;
            case 5:
                item.setStorage((Storage) aValue);
                break;
            case 6:
                item.setForm((Form) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }

}
