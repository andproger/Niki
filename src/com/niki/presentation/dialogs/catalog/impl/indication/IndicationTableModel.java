package com.niki.presentation.dialogs.catalog.impl.indication;

import com.niki.domain.entities.Indication;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class IndicationTableModel extends AbstractTableModel {
    private static final String[] columns = {"Симптом"};
    private List<Indication> users;

    public IndicationTableModel(List<Indication> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = users.get(i);

        if (i1 == 0) {
            return row.getDescription();
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
        var item = users.get(rowIndex);

        if (columnIndex == 0) {
            item.setDescription((String) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
