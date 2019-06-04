package com.niki.presentation.dialogs.catalog.impl.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;
import com.niki.domain.interactors.catalog.drug.DrugContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DrugsTableModel extends AbstractTableModel {
    private static final String[] columns = {"Имя", "Описание", "Цена", "Производитель", "Хранилище", "Форма", "Класс", "Количество"};
    private List<DrugContract> drugs;

    public DrugsTableModel(List<DrugContract> drugs) {
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
                return row.getName();
            case 1:
                return row.getDescription();
            case 2:
                return row.getCost();
            case 3:
                return row.getManufacturer();
            case 4:
                return row.getStorage();
            case 5:
                return row.getForm();
            case 6:
                return row.getDrugClass();
            case 7:
                return row.getDrugCount().get();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Manufacturer.class;
            case 4:
                return Storage.class;
            case 5:
                return Form.class;
            case 6:
                return DrugClass.class;
            case 7:
                return Integer.class;
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
        var item = drugs.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setName((String) aValue);
                break;
            case 1:
                item.setDescription((String) aValue);
                break;
            case 2:
                item.setCost((Double) aValue);
                break;
            case 3:
                item.setManufacturer((Manufacturer) aValue);
                break;
            case 4:
                item.setStorage((Storage) aValue);
                break;
            case 5:
                item.setForm((Form) aValue);
                break;
            case 6:
                item.setDrugClass((DrugClass) aValue);
                break;
            case 7:
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }

}
