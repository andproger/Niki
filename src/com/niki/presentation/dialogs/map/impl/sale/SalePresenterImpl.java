package com.niki.presentation.dialogs.map.impl.sale;

import com.niki.domain.interactors.catalog.sale.SaleContract;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;
import com.niki.domain.interactors.map.sale.SaleInteractor;
import com.niki.presentation.dialogs.catalog.impl.sale.NewSalesTableModel;
import com.niki.presentation.dialogs.map.BaseMapPresenter;
import com.niki.presentation.dialogs.map.MapView;

import java.util.ArrayList;

public class SalePresenterImpl extends BaseMapPresenter {

    private final SaleInteractor saleInteractor;
    // private int providerId;
    private int intakeId;
    private ArrayList<SaleContract> saleContracts;
    private ArrayList<SaleItemContract> intakeItems;
    private NewSalesTableModel saleItemTableModel;
    private SaleTableModel tableModel;

    public SalePresenterImpl(
            MapView view,
            SaleInteractor saleInteractor
    ) {
        super(view);
        this.saleInteractor = saleInteractor;
        initTableModels();
    }

    private void initTableModels() {
        this.intakeId = 0;
        this.saleContracts = saleInteractor.get();
        this.intakeItems = saleInteractor.getItems(intakeId);

        this.saleItemTableModel = new NewSalesTableModel(intakeItems);
        this.tableModel = new SaleTableModel(saleContracts);

        view.setItemTableModel(saleItemTableModel);
        view.setTableModel(tableModel);
    }

    @Override
    public void selectionChanged(int index) {
        System.out.println(index);
        var intakeItemContracts = saleInteractor.getItems(saleContracts.get(index).getId());
        intakeItems.clear();
        intakeItems.addAll(intakeItemContracts);
        saleItemTableModel.fireTableDataChanged();
    }
}
