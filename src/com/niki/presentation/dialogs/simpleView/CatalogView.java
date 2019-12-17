package com.niki.presentation.dialogs.simpleView;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public interface CatalogView {
    void setTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setTableCellRenderer(Class aClass, TableCellRenderer cellRenderer);
    void setControlsVisible(boolean isVisible);
}
