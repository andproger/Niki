package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Intake;

import java.util.ArrayList;
import java.util.List;

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
        var keys = insertItems(intakes, sqlInsert);
        return keys.get(0);
    }

    @Override
    public void deleteById(int intakeId) {
        List<Integer> ids = new ArrayList<>();
        ids.add(intakeId);

        deleteByIds(ids);
    }
}
