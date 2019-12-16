package com.niki.presentation.dialogs.sale;

import com.niki.data.cache.database.datastores.SqlAdminDataStore;
import com.niki.data.repository.UserAuthAuthInMemoryRepository;
import com.niki.domain.interactors.simpleView.sale.MakeSaleInteractorImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

public class NewSaleDialog extends JDialog implements NewSaleView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JButton addDrugButton;
    private JLabel sumLabel;
    private JButton deleteButton;

    private NewSalePresenter presenter;

    public NewSaleDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Оформление продажи");
        getRootPane().setDefaultButton(buttonOK);

        presenter = new NewSalesPresenterImpl(this, new MakeSaleInteractorImpl(
                new SaleRepositorySql(new SqlSaleDataStore()),
                new SaleItemRepositorySql(new SqlSaleItemDataStore()),
                new UserAuthAuthInMemoryRepository(new SqlAdminDataStore()))
        );
    }

    @Override
    public void initViews() {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        addDrugButton.addActionListener(e -> presenter.onAddClicked());
        deleteButton.addActionListener(e -> presenter.onDeleteClicked(table1.getSelectedRows()));
        table1.addPropertyChangeListener("tableCellEditor", evt -> presenter.onTableChanged());
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
        sumLabel.setText(sum);
    }

    private void onOK() {
        presenter.onOkClicked();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

}
