package com.niki.presentation.dialogs.intake;

import com.niki.domain.entities.Drug;
import com.niki.domain.interactors.catalog.intake.IntakeItemContract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class NewIntakeTableModel extends AbstractTableModel {
    private static final String[] columns = {"Медикамент", "Количество", "Стоимость"};
    private ArrayList<IntakeItemContract> contracts;

    public NewIntakeTableModel(ArrayList<IntakeItemContract> contracts) {
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
                return row.getDrug();
            case 1:
                return row.getQuantity();
            case 2:
                return row.getCost();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Drug.class;
            case 1:
                return Integer.class;
            case 2:
                return Double.class;
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
        var item = contracts.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setDrug((Drug) aValue);
                break;
            case 1:
                item.setQuantity((Integer) aValue);
                break;
            case 2:
                item.setCost((Double) aValue);
                break;
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
