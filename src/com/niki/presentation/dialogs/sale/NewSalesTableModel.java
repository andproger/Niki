package com.niki.presentation.dialogs.sale;

import com.niki.domain.interactors.simpleView.sale.SaleItemContract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class NewSalesTableModel extends AbstractTableModel {
    private static final String[] columns = {"Медикамент", "Цена", "Количество"};
    private ArrayList<SaleItemContract> saleItemContracts;

    public NewSalesTableModel(ArrayList<SaleItemContract> saleItemContracts) {
        this.saleItemContracts = saleItemContracts;
    }

    @Override
    public int getRowCount() {
        return saleItemContracts.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        var row = saleItemContracts.get(i);

        switch (i1) {
            case 0:
                return row.getDrug().getName();
            case 1:
                return row.getDrug().getCost();
            case 2:
                return row.getQuantity();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var item = saleItemContracts.get(rowIndex);

        if (columnIndex == 2) {
            item.setQuantity((Integer) aValue);
        }

        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
