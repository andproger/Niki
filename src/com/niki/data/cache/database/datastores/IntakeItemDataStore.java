package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.IntakeItem;

import java.util.List;

public interface IntakeItemDataStore extends DataStore<IntakeItem> {
    List<IntakeItem> get(int intakeId);
    void save(int intakeId, List<IntakeItem> items);
}
