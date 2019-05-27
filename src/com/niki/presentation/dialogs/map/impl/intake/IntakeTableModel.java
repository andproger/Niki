package com.niki.presentation.dialogs.map.impl.intake;

import com.niki.domain.entities.Provider;
import com.niki.domain.interactors.catalog.intake.IntakeContract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class IntakeTableModel extends AbstractTableModel {
    private static final String[] columns = {"ID", "Поставщик", "Дата/Время"};
    private ArrayList<IntakeContract> contracts;

    public IntakeTableModel(ArrayList<IntakeContract> contracts) {
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
                return row.getProvider();
            case 2: {
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
                return Provider.class;
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
                item.setProvider((Provider) aValue);
                break;
        }

    }
}
