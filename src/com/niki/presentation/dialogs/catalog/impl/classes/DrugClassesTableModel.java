package com.niki.presentation.dialogs.catalog.impl.classes;


import com.niki.domain.entities.DrugClass;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DrugClassesTableModel extends AbstractTableModel {
    private static final String[] columns = {"Класс"};
    private List<DrugClass> classes;

    public DrugClassesTableModel(List<DrugClass> classes) {
        this.classes = classes;
    }

    @Override
    public int getRowCount() {
        return classes.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = classes.get(i);

        if (i1 == 0) {
            return row.getName();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
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
        var item = classes.get(rowIndex);

        if (columnIndex == 0) {
            item.setName((String) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
