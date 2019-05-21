package com.niki.data.cache.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.Intake;

public interface IntakeDataStore extends DataStore<Intake> {
    int save(Intake intake);
}
