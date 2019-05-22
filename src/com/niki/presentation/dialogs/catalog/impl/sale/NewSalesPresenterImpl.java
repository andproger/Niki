package com.niki.presentation.dialogs.catalog.impl.sale;

import com.niki.domain.entities.Drug;
import com.niki.domain.interactors.catalog.sale.SaleContract;
import com.niki.domain.interactors.catalog.sale.SaleInteractor;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;
import com.niki.domain.interactors.catalog.sale.SaleItemInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class NewSalesPresenterImpl extends BaseCatalogPresenter {
    private final SaleItemInteractor saleItemInteractor;
    private final SaleInteractor saleInteractor;

    private NewSalesTableModel tableModel;
    private ArrayList<SaleItemContract> saleItems;

    public NewSalesPresenterImpl(CatalogView view, SaleItemInteractor saleItemInteractor, SaleInteractor saleInteractor) {
        super(view);
        this.saleItemInteractor = saleItemInteractor;
        this.saleInteractor = saleInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.saleItems = new ArrayList<>();//saleItemInteractor.getSaleItems();
        this.tableModel = new NewSalesTableModel(saleItems);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(saleItemInteractor.getDrugs()));
    }

    @Override
    public void onSaveClicked() {
        var id = saleInteractor.save(new SaleContract(0, 1, System.currentTimeMillis()));

        for (var item : saleItems)
            item.setSaleId(id);

        saleItemInteractor.saveSaleItems(saleItems);
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
