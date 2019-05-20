package com.niki.data.repository;

import com.niki.data.cache.datastores.SaleItemDataStore;
import com.niki.domain.entities.SaleItem;
import com.niki.domain.gateways.repositories.SaleItemRepository;

import java.util.ArrayList;

public class SaleItemRepositorySql implements SaleItemRepository {

    private final SaleItemDataStore dataStore;

    public SaleItemRepositorySql(SaleItemDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<SaleItem> getSaleItems() {
        return dataStore.getAll();
    }

    @Override
    public void saveSaleItem(ArrayList<SaleItem> sales) {
        dataStore.save(sales);
    }
}
