package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Drug;

import java.util.ArrayList;

public interface SaleItemInteractor {
    ArrayList<SaleItemContract> getSaleItems();

    void saveSaleItems(ArrayList<SaleItemContract> salesItems);

    ArrayList<Drug> getDrugs();
}
