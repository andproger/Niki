package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.SaleItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class SqlSaleItemDataStore extends SqlDataStore<SaleItem> implements SaleItemDataStore {

    public SqlSaleItemDataStore() {
        super(SaleItem.class);
    }

    @Override
    protected SaleItem newItemInstance() {
        return new SaleItem();
    }

    @Override
    public void save(ArrayList<SaleItem> items) {
        if (items.size() > 0)
            save(items.get(0).getSaleId(), items);
    }

    @Override
    public void save(int saleId, ArrayList<SaleItem> items) {
        try {
            connection.prepareStatement(sqlGen.delete("sale_id = " + saleId)).execute();
            var statement = connection.prepareStatement(sqlGen.insert());

            for (var item : items) {
                item.setSaleId(saleId);
                prepareInsert(statement, item);
                statement.execute();
            }

            statement.execute();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
