package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.IntakeItem;

import java.sql.SQLException;
import java.util.ArrayList;


public class SqlIntakeItemDataStore extends SqlDataStore<IntakeItem> implements IntakeItemDataStore {

    public SqlIntakeItemDataStore() {
        super(IntakeItem.class);
    }

    @Override
    protected IntakeItem newItemInstance() {
        return new IntakeItem();
    }

    @Override
    public void save(ArrayList<IntakeItem> items) {
        if (items.size() > 0)
            save(items.get(0).getIntakeId(), items);
    }

    @Override
    public ArrayList<IntakeItem> getAll() {
        var sqlSelect = sqlGen.select(null, null);

        return select(sqlSelect);
    }

    @Override
    public ArrayList<IntakeItem> get(int intakeId) {
        var sqlSelect = sqlGen.select(null, "where intake_id = " + intakeId);

        return select(sqlSelect);
    }

    @Override
    public void save(int intakeId, ArrayList<IntakeItem> items) {
        try {
            connection.prepareStatement(sqlGen.delete("intake_id = " + intakeId)).execute();
            var statement = connection.prepareStatement(sqlGen.insert());

            for (var item : items) {
                item.setIntakeId(intakeId);
                prepareInsert(statement, item);
                statement.execute();
            }

            statement.execute();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
