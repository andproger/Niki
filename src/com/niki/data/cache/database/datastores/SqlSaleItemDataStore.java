package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.SaleItem;

public class SqlSaleItemDataStore extends SqlDataStore<SaleItem> implements SaleItemDataStore {

    public SqlSaleItemDataStore() {
        super(SaleItem.class);
    }

    @Override
    protected SaleItem newItemInstance() {
        return new SaleItem();
    }
}
