package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.DrugCount;
import com.niki.domain.entities.Position;

public interface DrugCountDataStore extends DataStore<DrugCount> {
    DrugCount get(int drugId);
}
