package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.SaleItem;

import java.util.ArrayList;

public interface SaleItemRepository {
    ArrayList<SaleItem> getSaleItems();

    void saveSaleItem(ArrayList<SaleItem> sales);
}
