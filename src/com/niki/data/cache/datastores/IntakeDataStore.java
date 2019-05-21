package com.niki.data.cache.datastores;

import com.niki.data.cache.datastores.base.DataStore;
import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Intake;

public interface IntakeDataStore extends DataStore<Intake> {
    int save(Intake intake);
}
