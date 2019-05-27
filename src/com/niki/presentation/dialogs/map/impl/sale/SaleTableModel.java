package com.niki.presentation.dialogs.map.impl.sale;

import com.niki.domain.entities.User;
import com.niki.domain.interactors.catalog.sale.SaleContract;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

public class SaleTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Пользователь", "Дата/Время"};
    private List<SaleContract> contracts;

    public SaleTableModel(List<SaleContract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public int getRowCount() {
        return contracts.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = contracts.get(i);

        switch (i1) {
            case 0:
                return row.getId();
            case 1:
                return row.getUser();
            case 2:
            {
                var date = new Date(row.getDateTime());
                return date.toString();
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
                return User.class;
            case 2:
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
        return false;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = contracts.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setId((Integer) aValue);
                break;
            case 1:
                item.setUser((User) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
