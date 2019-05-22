package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.SaleItem;

import java.util.ArrayList;

public interface SaleItemDataStore extends DataStore<SaleItem> {
    void save(int saleId, ArrayList<SaleItem> items);
}
