package com.niki.presentation.dialogs.simpleView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CellRenderer<T> extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            if (value instanceof ArrayList) {
                var list= (ArrayList) value;
                setText(Arrays.toString(list.toArray()));
            } else {
                var item = (T) value;
                setText(item.toString());
            }
        } else
            setText("");

        return this;
    }

}
