package com.niki.presentation.dialogs.catalog.impl.user;

import com.niki.domain.entities.Position;
import com.niki.domain.interactors.catalog.user.UserContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsersTableModel extends AbstractTableModel {
    private static final String[] columns = {"Логин", "Имя", "Фамилия", "Должность", "Email", "Телефон"};
    private List<UserContract> users;

    UsersTableModel(List<UserContract> users) {
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
                return row.getFirstName();
            case 2:
                return row.getLastName();
            case 3:
                return row.getPosition();
            case 4:
                return row.getContact().getEmail();
            case 5:
                return row.getContact().getPhone();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
                return String.class;
            case 3:
                return Position.class;
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
                item.setFirstName((String) aValue);
                break;
            case 2:
                item.setLastName((String) aValue);
                break;
            case 3:
                item.setPosition((Position) aValue);
                break;
            case 4:
                item.getContact().setEmail((String) aValue);
                break;
            case 5:
                item.getContact().setPhone((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
