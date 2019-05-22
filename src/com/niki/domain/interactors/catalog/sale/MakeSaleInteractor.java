package com.niki.domain.interactors.catalog.sale;

import java.util.List;

public interface MakeSaleInteractor {
    int add(List<SaleItemContract> contractItems);

    void change(int saleId, List<SaleItemContract> contractItems);

    void remove(int saleId);
}
