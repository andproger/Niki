package com.niki.presentation.dialogs.mapView;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public interface MapView {
    void setTableModel(AbstractTableModel tableModel);
    void setItemTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setTableCellRenderer(Class aClass, DefaultTableCellRenderer cellRenderer);
}
