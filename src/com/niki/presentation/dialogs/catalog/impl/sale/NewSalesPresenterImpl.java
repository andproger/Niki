package com.niki.presentation.dialogs.catalog.impl.sale;

import com.niki.domain.entities.Drug;
import com.niki.domain.interactors.catalog.sale.SaleInteractor;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class NewSalesPresenterImpl extends BaseCatalogPresenter {
    private final SaleInteractor saleInteractor;

    private NewSalesTableModel tableModel;
    private ArrayList<SaleItemContract> saleItems;

    public NewSalesPresenterImpl(CatalogView view, SaleInteractor saleInteractor) {
        super(view);
        this.saleInteractor = saleInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.saleItems = saleInteractor.getSaleItems();
        this.tableModel = new NewSalesTableModel(saleItems);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(saleInteractor.getDrugs()));
    }

    @Override
    public void onSaveClicked() {
        saleInteractor.saveSaleItems(saleItems);
    }

    @Override
    public void onAddClicked() {
        saleItems.add(new SaleItemContract(0, 0, 0, null));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.saleItems.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
