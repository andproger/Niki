package com.niki.presentation.dialogs.sale;

import com.niki.domain.interactors.catalog.sale.MakeSaleInteractor;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;
import com.niki.presentation.dialogs.sale.create.CreateSaleDialog;

import java.util.ArrayList;

public class NewSalesPresenterImpl implements NewSalePresenter {
    private final NewSaleView view;

    private final MakeSaleInteractor makeSaleInteractor;

    private NewSalesTableModel tableModel;
    private ArrayList<SaleItemContract> saleItems;

    private int saleId;

    public NewSalesPresenterImpl(
            NewSaleView view,
            MakeSaleInteractor makeSaleInteractor
    ) {
        this.view = view;
        this.makeSaleInteractor = makeSaleInteractor;

        initTableModel();
        view.initViews();
    }

    private void initTableModel() {
        this.saleId = 0;
        this.saleItems = new ArrayList<>();
        this.tableModel = new NewSalesTableModel(saleItems);

        view.setTableModel(tableModel);
    }

    @Override
    public void onOkClicked(int providerId) {
        if (saleId == 0) {
            if (!saleItems.isEmpty()) {
                saleId = makeSaleInteractor.add(saleItems);
            }
        } else {
            if (!saleItems.isEmpty()) {
                makeSaleInteractor.change(saleId, saleItems);
            } else {
                makeSaleInteractor.remove(saleId);
            }
        }
    }

    @Override
    public void onAddClicked() {
        var createSale = new CreateSaleDialog();
        createSale.pack();
        createSale.setVisible(true);
        var saleItem = createSale.getContract();

        if (saleItem != null) {
            saleItems.add(saleItem);
            tableModel.fireTableDataChanged();
            updateSum();
        }
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.saleItems.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }

    private void updateSum() {
        double sum = 0;

        for (var item : saleItems)
            sum += item.getDrug().getCost() * item.getQuantity();

        view.setSum(String.valueOf(sum));
    }
}
