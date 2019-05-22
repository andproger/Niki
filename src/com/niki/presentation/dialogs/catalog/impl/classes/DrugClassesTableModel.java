package com.niki.presentation.dialogs.catalog.impl.classes;


import com.niki.domain.entities.DrugClass;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DrugClassesTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Класс"};
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
        var item = classes.get(rowIndex);

        if (columnIndex == 1) {
            item.setName((String) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
