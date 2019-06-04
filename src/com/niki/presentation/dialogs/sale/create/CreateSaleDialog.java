package com.niki.presentation.dialogs.sale.create;

import com.niki.data.cache.database.datastores.*;
import com.niki.data.repository.*;
import com.niki.domain.entities.Drug;
import com.niki.domain.interactors.catalog.drug.DrugContract;
import com.niki.domain.interactors.catalog.drug.DrugInteractorImpl;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CreateSaleDialog extends JDialog implements CreateSaleView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox drugComboBox;
    private JSpinner spinner1;

    private SaleItemContract contract;
    private CreateSalePresenter presenter;

    public CreateSaleDialog() {
        setContentPane(contentPane);
        setModal(true);
        presenter = new CreateSalePresenterImpl(this, new DrugInteractorImpl(
                new DrugRepositorySql(new SqlDrugDataStore()),
                new ClassRepositorySql(new SqlDrugClassDataStore()),
                new FormRepositorySql(new SqlFormDataStore()),
                new StorageRepositorySql(new SqlStorageDataStore()),
                new ManufacturerRepositorySql(new SqlManufacturerDataStore()),
                new DrugCountRepositorySql(new SqlDrugCountDataStore())
        ));

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        var count = (Integer) spinner1.getValue();


        if (count <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Не правильно заданно количество медикаментов", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else if (count > ((DrugContract) drugComboBox.getSelectedItem()).getDrugCount().get()) {
            JOptionPane.showMessageDialog(this,
                    "Не правильно заданно количество медикаментов. Нельзя продать больше, чем есть на складе",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            var drugContract = (DrugContract) drugComboBox.getSelectedItem();
            var drug = new Drug(drugContract.getId(),
                    drugContract.getCost(),
                    drugContract.getDrugClass().getId(),
                    drugContract.getManufacturer().getId(),
                    drugContract.getStorage().getId(),
                    drugContract.getForm().getId(),
                    drugContract.getName(),
                    drugContract.getDescription());

            contract = new SaleItemContract(
                    0,
                    count,
                    drug
            );

            dispose();
        }
    }

    private void onCancel() {
        dispose();
    }

    public SaleItemContract getContract() {
        return contract;
    }

    @Override
    public void initViews(List<DrugContract> drugs) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var drug : drugs)
            drugComboBox.addItem(drug);
    }
}
