package com.niki.presentation.dialogs.simpleView.impl.user;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.admin.AdminContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsersTableModel extends AbstractTableModel {
    private static final String[] columns = {"Логин", "Персона"};
    private List<AdminContract> users;

    UsersTableModel(List<AdminContract> users) {
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

        switch (i1) {
            case 0:
                return row.getLogin();
            case 1:
                return row.getPerson();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Person.class;
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

        switch (columnIndex) {
            case 0:
                item.setLogin((String) aValue);
            case 1:
                item.setPerson((Person) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
