package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.IntakeItem;

import java.util.ArrayList;

public interface IntakeItemDataStore extends DataStore<IntakeItem> {
    ArrayList<IntakeItem> get(int intakeId);
    void save(int intakeId, ArrayList<IntakeItem> items);
}
