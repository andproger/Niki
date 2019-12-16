package com.niki.presentation.dialogs.sale;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

public interface NewSaleView {
    void initViews();
    void setTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setSum(String sum);
}
