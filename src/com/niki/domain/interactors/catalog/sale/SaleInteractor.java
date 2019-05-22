package com.niki.domain.interactors.catalog.sale;

import java.util.ArrayList;

public interface SaleInteractor {
    ArrayList<SaleContract> get();

    int save(SaleContract contract);
}
