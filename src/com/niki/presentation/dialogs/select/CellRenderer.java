package com.niki.presentation.dialogs.select;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CellRenderer<T> extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            var item = (T) value;
            setText(item.toString());
        } else
            setText("");

        return this;
    }

}
