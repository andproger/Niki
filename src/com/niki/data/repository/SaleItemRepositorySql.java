package com.niki.data.repository;

import com.niki.data.cache.database.datastores.SaleItemDataStore;
import com.niki.domain.entities.SaleItem;
import com.niki.domain.gateways.repositories.SaleItemRepository;

import java.util.List;

public class SaleItemRepositorySql implements SaleItemRepository {

    private final SaleItemDataStore dataStore;

    public SaleItemRepositorySql(SaleItemDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<SaleItem> get() {
        return dataStore.getAll();
    }

    @Override
    public void save(List<SaleItem> sales) {
        dataStore.save(sales);
    }

    @Override
    public void deleteBySaleId(int saleId) {
        dataStore.deleteBySaleId(saleId);
    }
}
