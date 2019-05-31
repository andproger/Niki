package com.niki.presentation.dialogs.intake.create;

import com.niki.data.cache.database.datastores.SqlDrugDataStore;
import com.niki.data.repository.DrugRepositorySql;
import com.niki.domain.entities.Drug;
import com.niki.domain.interactors.catalog.intake.IntakeItemContract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CreateIntakeDialog extends JDialog implements CreateIntakeView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox drugComboBox;
    private JTextField costField;
    private JSpinner spinner1;

    private IntakeItemContract contract;
    private CreateIntakePresenter presenter;

    public CreateIntakeDialog() {
        setContentPane(contentPane);
        setModal(true);
        presenter = new CreateIntakePresenterImpl(this, new DrugRepositorySql(new SqlDrugDataStore()));

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
            return;
        }

        double cost;
        try {
            cost = Double.parseDouble(costField.getText());
        } catch (Exception e) {
            cost = -1;
        }

        if (cost < 0) {
            JOptionPane.showMessageDialog(this,
                    "Не правильно заданна стоимость", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        contract = new IntakeItemContract(0, (Drug) drugComboBox.getSelectedItem(), count, cost);
        dispose();
    }


    private void onCancel() {
        dispose();
    }

    public IntakeItemContract getContract() {
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
