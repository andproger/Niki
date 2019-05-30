package com.niki.presentation.dialogs.sale.create;

import com.niki.domain.gateways.repositories.DrugRepository;

public class CreateSalePresenterImpl implements CreateSalePresenter {
    private final CreateSaleView view;
    private final DrugRepository drugRepository;


    CreateSalePresenterImpl(CreateSaleView view, DrugRepository drugRepository) {
        this.view = view;
        this.drugRepository = drugRepository;
        initViews();
    }

    private void initViews() {
        this.view.initViews(drugRepository.getDrugs());
    }
}
