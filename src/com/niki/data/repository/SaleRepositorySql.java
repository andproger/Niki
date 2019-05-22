package com.niki.data.repository;

import com.niki.data.cache.database.datastores.SaleDataStore;
import com.niki.domain.entities.Sale;
import com.niki.domain.gateways.repositories.SaleRepository;

import java.util.List;

public class SaleRepositorySql implements SaleRepository {

    private final SaleDataStore dataStore;

    public SaleRepositorySql(SaleDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Sale> get() {
        return dataStore.getAll();
    }

    @Override
    public int save(Sale sale) {
        return dataStore.save(sale);
    }

    @Override
    public void deleteById(int saleId) {
        dataStore.deleteById(saleId);
    }

}
