package com.niki.presentation.dialogs.catalog.impl.sale;

import com.niki.domain.entities.Drug;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.interactors.catalog.sale.*;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class NewSalesPresenterImpl extends BaseCatalogPresenter {
    private final DrugRepository drugRepository;

    private final MakeSaleInteractor makeSaleInteractor;

    private NewSalesTableModel tableModel;
    private ArrayList<SaleItemContract> saleItems;

    private int saleId;

    public NewSalesPresenterImpl(
            CatalogView view,
            MakeSaleInteractor makeSaleInteractor,
            DrugRepository drugRepository
    ) {
        super(view);
        this.drugRepository = drugRepository;
        this.makeSaleInteractor = makeSaleInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.saleId = 0;
        this.saleItems = new ArrayList<>();
        this.tableModel = new NewSalesTableModel(saleItems);

        var drugs = drugRepository.getDrugs();

        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(drugs));
    }

    @Override
    public void onSaveClicked() {
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
