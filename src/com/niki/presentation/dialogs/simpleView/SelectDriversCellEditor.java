package com.niki.presentation.dialogs.simpleView;

import com.niki.data.cache.database.datastores.SqlDriverDataStore;
import com.niki.data.cache.database.datastores.SqlPersonDataStore;
import com.niki.data.repository.DriverRepositorySql;
import com.niki.data.repository.PersonRepositorySql;
import com.niki.domain.entities.Driver;
import com.niki.domain.interactors.simpleView.driver.DriverContract;
import com.niki.domain.interactors.simpleView.driver.DriverInteractorImpl;
import com.niki.presentation.dialogs.select.SelectDialog;
import com.niki.presentation.dialogs.select.impl.driver.DriverPresenterImpl;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectDriversCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    List<Driver> drivers;
    JButton button;
    SelectDialog dialog;
    protected static final String EDIT = "edit";

    public SelectDriversCellEditor() {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);

        dialog = new SelectDialog();
    }

    public void actionPerformed(ActionEvent e) {
        if (EDIT.equals(e.getActionCommand())) {
            dialog.setVisible(true);
            List<DriverContract> contracts = dialog.GetSelected();

            drivers.clear();

            for(var contract : contracts)
                drivers.add(new Driver(contract.getId(), contract.getPerson().getId(), contract.getCard()));

            fireEditingStopped(); //Make the renderer reappear.
        }
    }

    public Object getCellEditorValue() {
        return drivers;
    }

    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row,
                                                 int column) {
        drivers = (List<Driver>)value;
        return button;
    }
}
