package com.niki.presentation.dialogs.sale.create;

import com.niki.domain.interactors.simpleView.drug.DrugContract;

import java.util.List;

public interface CreateSaleView {
    void initViews(List<DrugContract> drugs);
}
