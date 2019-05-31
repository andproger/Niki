package com.niki.presentation.dialogs.intake;

import com.niki.domain.entities.Provider;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import java.util.List;

public interface NewIntakeView {
    void initViews(List<Provider> providers);
    void setTableModel(AbstractTableModel tableModel);
    void setTableCellEditor(Class aClass, TableCellEditor cellEditor);
    void setSum(String sum);
}
