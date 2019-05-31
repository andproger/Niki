package com.niki.presentation.dialogs.intake;

import com.niki.data.cache.database.datastores.SqlDrugDataStore;
import com.niki.data.cache.database.datastores.SqlIntakeDataStore;
import com.niki.data.cache.database.datastores.SqlIntakeItemDataStore;
import com.niki.data.cache.database.datastores.SqlProviderDataStore;
import com.niki.data.repository.DrugRepositorySql;
import com.niki.data.repository.IntakeItemRepositorySql;
import com.niki.data.repository.IntakeRepositorySql;
import com.niki.data.repository.ProviderRepositorySql;
import com.niki.domain.entities.Provider;
import com.niki.domain.interactors.catalog.intake.IntakeInteractorImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import java.util.List;
import java.util.Objects;

public class NewIntakeDialog extends JDialog implements NewIntakeView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTable table1;
    private JButton addButton;
    private JLabel sum;

    private NewIntakePresenter presenter;

    public NewIntakeDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Новое поступление");
        getRootPane().setDefaultButton(buttonOK);

        presenter = new NewIntakePresenterImpl(
                this,
                new DrugRepositorySql(new SqlDrugDataStore()),
                new IntakeInteractorImpl(
                        new ProviderRepositorySql(new SqlProviderDataStore()),
                        new IntakeRepositorySql(new SqlIntakeDataStore()),
                        new IntakeItemRepositorySql(new SqlIntakeItemDataStore())
                )
        );
    }

    @Override
    public void initViews(List<Provider> providers) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        addButton.addActionListener(e -> presenter.onAddClicked());
        table1.addPropertyChangeListener("tableCellEditor", evt -> presenter.onTableChanged());

        for (var provider : providers)
            comboBox1.addItem(provider);
    }

    @Override
    public void setTableModel(AbstractTableModel tableModel) {
        table1.setModel(tableModel);
    }

    @Override
    public void setTableCellEditor(Class aClass, TableCellEditor cellEditor) {
        table1.setDefaultEditor(aClass, cellEditor);
    }

    @Override
    public void setSum(String sum) {
        this.sum.setText(sum);
    }

    private void onOK() {
        presenter.onSaveClicked(((Provider) Objects.requireNonNull(comboBox1.getSelectedItem())).getId());
    }

    private void onCancel() {
        dispose();
    }
}
