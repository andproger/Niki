package com.niki.presentation.dialogs.select;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public interface SelectView {
    void setTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setTableCellRenderer(Class aClass, TableCellRenderer cellRenderer);
}
