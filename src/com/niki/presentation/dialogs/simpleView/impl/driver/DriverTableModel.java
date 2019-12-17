package com.niki.presentation.dialogs.simpleView.impl.driver;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.driver.DriverContract;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DriverTableModel extends AbstractTableModel {
    private static final String[] columns = {"Сотрудник", "Номер прав"};
    private List<DriverContract> users;

    public DriverTableModel(List<DriverContract> users) {
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
                return row.getPerson();
            case 1:
                return row.getCard();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Person.class;
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
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = users.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setPerson((Person) aValue);
                break;
            case 1:
                item.setCard((String) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
