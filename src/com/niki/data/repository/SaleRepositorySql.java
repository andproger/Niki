package com.niki.data.repository;

import com.niki.data.cache.database.datastores.IntakeDataStore;
import com.niki.data.cache.database.datastores.SaleDataStore;
import com.niki.domain.entities.Intake;
import com.niki.domain.entities.Sale;
import com.niki.domain.gateways.repositories.IntakeRepository;
import com.niki.domain.gateways.repositories.SaleRepository;

import java.util.ArrayList;

public class SaleRepositorySql implements SaleRepository {

    private final SaleDataStore dataStore;

    public SaleRepositorySql(SaleDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public ArrayList<Sale> get() {
        return dataStore.getAll();
    }

    @Override
    public int save(Sale sale) {
        return dataStore.save(sale);
    }

}
