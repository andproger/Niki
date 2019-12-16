package com.niki.presentation.dialogs.sale.create;

import com.niki.domain.interactors.simpleView.drug.DrugContract;
import com.niki.domain.interactors.simpleView.drug.DrugInteractor;

import java.util.ArrayList;

public class CreateSalePresenterImpl implements CreateSalePresenter {
    private final CreateSaleView view;
    private final DrugInteractor drugInteractor;


    CreateSalePresenterImpl(CreateSaleView view, DrugInteractor drugInteractor) {
        this.view = view;
        this.drugInteractor = drugInteractor;
        initViews();
    }

    private void initViews() {
        var drugsOnStorage = new ArrayList<DrugContract>();
        for (var contract : drugInteractor.getDrugs())
            if (contract.getDrugCount().get() > 0)
                drugsOnStorage.add(contract);

        this.view.initViews(drugsOnStorage);
    }
}
