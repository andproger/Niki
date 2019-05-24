package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.IntakeItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SqlIntakeItemDataStore extends SqlDataStore<IntakeItem> implements IntakeItemDataStore {

    public SqlIntakeItemDataStore() {
        super(IntakeItem.class);
    }

    @Override
    protected IntakeItem newItemInstance() {
        return new IntakeItem();
    }

    @Override
    public void deleteByIntakeId(int intakeId) {
        try {
            connection.prepareStatement(sqlGen.delete("where intake_id = " + intakeId))
                    .execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<IntakeItem> get(int intakeId) {
        var intakeItems = new ArrayList<IntakeItem>();

        try {
            var statement = connection.prepareStatement(sqlGen.select("where intake_id = " + intakeId, null));
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                intakeItems.add(new IntakeItem(
                        resultSet.getInt("intake_id"),
                        resultSet.getInt("drug_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("cost")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return intakeItems;
    }

    @Override
    public void save(List<IntakeItem> items) {
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
