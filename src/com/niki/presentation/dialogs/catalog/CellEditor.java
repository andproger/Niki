package com.niki.presentation.dialogs.catalog;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CellEditor<T> extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    private T item;
    private List<T> items;

    public CellEditor(List<T> items) {
        this.items = items;
    }

    @Override
    public Object getCellEditorValue() {
        return this.item;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (value != null) {
            this.item = (T) value;
        }

        var formsCombo = new JComboBox<T>();

        for (var item : this.items) {
            formsCombo.addItem(item);
        }

        formsCombo.setSelectedItem(item);
        formsCombo.addActionListener(this);

        return formsCombo;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        var comboForms = (JComboBox<T>) event.getSource();
        this.item = (T) comboForms.getSelectedItem();
    }
}
