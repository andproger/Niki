package com.niki.data.repository;

import com.niki.domain.entities.SaleItem;
import com.niki.domain.gateways.repositories.SaleItemRepository;

import java.util.ArrayList;

public class SaleItemItemRepositorySql implements SaleItemRepository {
    @Override
    public ArrayList<SaleItem> getSaleItems() {
        var sales = new ArrayList<SaleItem>();
        for (int i = 0; i < 10; i++)
            sales.add(new SaleItem(0, 0, 0, 0));
        return sales;
    }

    @Override
    public void saveSaleItem(ArrayList<SaleItem> sales) {

    }
}
