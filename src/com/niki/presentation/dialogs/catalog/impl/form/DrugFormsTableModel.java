package com.niki.presentation.dialogs.catalog.impl.form;

import com.niki.domain.entities.Form;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DrugFormsTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Форма"};
    private List<Form> forms;

    public DrugFormsTableModel(List<Form> forms) {
        this.forms = forms;
    }

    @Override
    public int getRowCount() {
        return forms.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = forms.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getName();
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
        var item = forms.get(rowIndex);

        switch (columnIndex) {
            case 1:
                item.setName((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
