package com.niki.presentation.dialogs.catalog.impl.user;

import com.niki.domain.entities.Position;
import com.niki.domain.entities.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UsersTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Login", "First Name", "Last Name", "Position"};
    private ArrayList<User> users;
    private ArrayList<Position> positions;

    public UsersTableModel(ArrayList<User> users, ArrayList<Position> positions) {
        this.users = users;
        this.positions = positions;
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
                return row.getId();
            case 1:
                return row.getLogin();
            case 2:
                return row.getFirstName();
            case 3:
                return row.getLastName();
            case 4: {
                var position = new Position(row.getId(), 0, "");
                var index = Collections.binarySearch(positions, position, Comparator.comparingInt(Position::getId));
                return index >= 0 ? positions.get(index) : null;
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
            case 3:
                return String.class;
            case 4:
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
        return columnIndex != 0;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = users.get(rowIndex);
//    xlnt::worksheet ws

        switch (columnIndex) {
            case 1:
                item.setFirstName((String) aValue);
                break;
            case 2:
                item.setLastName((String) aValue);
                break;
            case 3:
                item.setPositionId(((Position) aValue).getId());
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
