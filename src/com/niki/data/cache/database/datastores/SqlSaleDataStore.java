package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Sale;

import java.util.ArrayList;
import java.util.List;

public class SqlSaleDataStore extends SqlDataStore<Sale> implements SaleDataStore {

    public SqlSaleDataStore() {
        super(Sale.class);
    }

    @Override
    protected Sale newItemInstance() {
        return new Sale();
    }

    public int save(Sale sale) {
        var sqlInsert = sqlGen.insert();
        var sales = new ArrayList<Sale>();
        sales.add(sale);
        var keys = insertItems(sales, sqlInsert);
        return keys.get(0);
    }

    @Override
    public void deleteById(int saleId) {
        List<Integer> ids = new ArrayList<>();
        ids.add(saleId);

        deleteByIds(ids);
    }
}
