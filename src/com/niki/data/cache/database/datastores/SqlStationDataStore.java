package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Person;
import com.niki.domain.entities.Station;

public class SqlStationDataStore extends SqlDataStore<Station> implements StationDataStore {

    public SqlStationDataStore() {
        super(Station.class);
    }

    @Override
    protected Station newItemInstance() {
        return new Station();
    }
}
