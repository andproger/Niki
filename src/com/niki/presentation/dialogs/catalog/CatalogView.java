package com.niki.presentation.dialogs.catalog;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public interface CatalogView {
    void setTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setTableCellRenderer(Class aClass, DefaultTableCellRenderer cellRenderer);
}
