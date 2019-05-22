package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.SaleItem;

import java.sql.SQLException;
import java.util.List;

public class SqlSaleItemDataStore extends SqlDataStore<SaleItem> implements SaleItemDataStore {

    public SqlSaleItemDataStore() {
        super(SaleItem.class);
    }

    @Override
    protected SaleItem newItemInstance() {
        return new SaleItem();
    }

    @Override
    public void deleteBySaleId(int saleId) {
        try {
            connection.prepareStatement(sqlGen.delete("where sale_id = " + saleId))
                    .execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(List<SaleItem> items) {
        try {
            var statement = connection.prepareStatement(sqlGen.insert());

            for (var item : items) {
                prepareInsert(statement, item);
                statement.execute();
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
