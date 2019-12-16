package com.niki.presentation.dialogs.simpleView.impl.person;

import com.niki.domain.entities.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private static final String[] columns = {"Имя", "Фамили", "Адрес", "Номер"};
    private List<Person> items;

    PersonTableModel(List<Person> users) {
        this.items = users;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = items.get(i);

        switch (i1) {
            case 0:
                return row.getFirstName();
            case 1:
                return row.getLastName();
            case 2:
                return row.getHomeAddress();
            case 3:
                return row.getNumber();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
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
        var item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setFirstName((String) aValue);
            case 1:
                item.setLastName((String) aValue);
            case 2:
                item.setHomeAddress((String) aValue);
            case 3:
                item.setNumber((String) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
