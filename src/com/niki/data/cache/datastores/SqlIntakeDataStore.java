package com.niki.data.cache.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Intake;

import java.util.ArrayList;

public class SqlIntakeDataStore extends SqlDataStore<Intake> implements IntakeDataStore {

    public SqlIntakeDataStore() {
        super(Intake.class);
    }

    @Override
    protected Intake newItemInstance() {
        return new Intake();
    }

    public int save(Intake intake) {
        var sqlInsert = sqlGen.insert();
        var intakes = new ArrayList<Intake>();
        intakes.add(intake);
        insertItems(intakes, sqlInsert);
        return getIndentity();
    }
}
