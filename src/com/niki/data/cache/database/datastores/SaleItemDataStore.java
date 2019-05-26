package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.SaleItem;

import java.util.List;

public interface SaleItemDataStore extends DataStore<SaleItem> {
    List<SaleItem> get(int saleId);
    void save(List<SaleItem> items);

    void deleteBySaleId(int saleId);
}
