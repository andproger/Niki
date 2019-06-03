package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.DrugCount;

import java.sql.SQLException;

public class SqlDrugCountDataStore extends SqlDataStore<DrugCount> implements DrugCountDataStore {

    public SqlDrugCountDataStore() {
        super(DrugCount.class);
    }

    @Override
    protected DrugCount newItemInstance() {
        return new DrugCount();
    }

    @Override
    public DrugCount get(int drugId) {
        try {
            var sql = "select " + DATABASE + ".drug_count(?)";
            var statement = this.connection.prepareStatement(sql);
            statement.setInt(1, drugId);
            var result = statement.executeQuery();
            if(result.next()) {
                return new DrugCount(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
}
