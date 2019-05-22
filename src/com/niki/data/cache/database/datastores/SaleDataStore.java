package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.Sale;

public interface SaleDataStore extends DataStore<Sale> {
    int save(Sale sale);

    void deleteById(int saleId);
}
