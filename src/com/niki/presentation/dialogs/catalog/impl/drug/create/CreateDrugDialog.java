package com.niki.presentation.dialogs.catalog.impl.drug.create;

import com.niki.data.cache.database.datastores.SqlDrugClassDataStore;
import com.niki.data.cache.database.datastores.SqlFormDataStore;
import com.niki.data.cache.database.datastores.SqlManufacturerDataStore;
import com.niki.data.cache.database.datastores.SqlStorageDataStore;
import com.niki.data.repository.ClassRepositorySql;
import com.niki.data.repository.FormRepositorySql;
import com.niki.data.repository.ManufacturerRepositorySql;
import com.niki.data.repository.StorageRepositorySql;
import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;
import com.niki.domain.interactors.catalog.drug.DrugContract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CreateDrugDialog extends JDialog implements CreateDrugView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldName;
    private JComboBox comboBoxClass;
    private JComboBox comboBoxManufacturer;
    private JComboBox comboBoxForm;
    private JTextField textFieldCost;
    private JTextArea textAreaDescription;
    private JComboBox comboBoxStorage;

    private DrugContract drugContract;

    private CreateDrugPresenter presenter;

    public CreateDrugDialog() {
        setContentPane(contentPane);
        setModal(true);
        presenter = new CreateDrugPresenterImpl(
                this,
                new FormRepositorySql(new SqlFormDataStore()),
                new ManufacturerRepositorySql(new SqlManufacturerDataStore()),
                new StorageRepositorySql(new SqlStorageDataStore()),
                new ClassRepositorySql(new SqlDrugClassDataStore()));

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        drugContract = new DrugContract(
                0,
                Double.parseDouble(textFieldCost.getText()),
                textFieldName.getText(),
                textAreaDescription.getText(),
                (DrugClass) comboBoxClass.getSelectedItem(),
                (Manufacturer) comboBoxManufacturer.getSelectedItem(),
                (Storage) comboBoxStorage.getSelectedItem(),
                (Form) comboBoxForm.getSelectedItem());

        dispose();
    }

    private void onCancel() {
        dispose();
    }


    @Override
    public void initViews(List<Manufacturer> manufacturers, List<Storage> storages, List<Form> forms, List<DrugClass> classes) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var drugClass : classes)
            comboBoxClass.addItem(drugClass);

        for (var form : forms)
            comboBoxForm.addItem(form);

        for (var storage : storages)
            comboBoxStorage.addItem(storage);

        for (var manufacturer : manufacturers)
            comboBoxManufacturer.addItem(manufacturer);
    }

    public DrugContract getDrugContract() {
        return drugContract;
    }
}
