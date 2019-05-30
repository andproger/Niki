package com.niki.presentation.dialogs.sale.create;

import com.niki.data.cache.database.datastores.SqlDrugDataStore;
import com.niki.data.repository.DrugRepositorySql;
import com.niki.domain.entities.Drug;
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
        presenter = new CreateSalePresenterImpl(this, new DrugRepositorySql(new SqlDrugDataStore()));

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
        } else {
            contract = new SaleItemContract(
                    0,
                    count,
                    (Drug) drugComboBox.getSelectedItem()
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
    public void initViews(List<Drug> drugs) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var drug : drugs)
            drugComboBox.addItem(drug);
    }
}
