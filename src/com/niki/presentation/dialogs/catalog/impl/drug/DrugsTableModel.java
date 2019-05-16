package com.niki.presentation.dialogs.catalog.impl.drug;

import com.niki.domain.entities.Drug;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DrugsTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Имя", "Описание", "Цена", "Производитель", "Хранилище", "Форма"};
    private ArrayList<Drug> drugs;
    private ArrayList<Manufacturer> manufacturers;
    private ArrayList<Form> forms;
    private ArrayList<Storage> storages;

    public DrugsTableModel(ArrayList<Drug> drugs, ArrayList<Manufacturer> manufacturers, ArrayList<Form> forms, ArrayList<Storage> storages) {
        this.drugs = drugs;
        this.manufacturers = manufacturers;
        this.forms = forms;
        this.storages = storages;
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
                var manufacturer = new Manufacturer(row.getManufacturerId(), 0, "", "");
                var index = Collections.binarySearch(manufacturers, manufacturer, Comparator.comparingInt(Manufacturer::getId));
                return index >= 0 ? manufacturers.get(index) : null;
            }
            case 5: {
                var storage = new Storage(row.getStorageId(), "");
                var index = Collections.binarySearch(storages, storage, Comparator.comparingInt(Storage::getId));
                return index >= 0 ? storages.get(index) : null;
            }
            case 6: {
                var form = new Form(row.getFormId(), "");
                var index = Collections.binarySearch(forms, form, Comparator.comparingInt(Form::getId));
                return index >= 0 ? forms.get(index) : null;
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
            case 4:
                item.setManufacturerId(((Manufacturer) aValue).getId());
            case 5:
                item.setStorageId(((Storage) aValue).getId());
            case 6:
                item.setFormId(((Form) aValue).getId());

        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }

}
