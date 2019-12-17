package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.DataStore;
import com.niki.domain.entities.Driver;
import com.niki.domain.entities.FlightDriver;

import java.util.List;

public interface FlightDriverDataStore extends DataStore<FlightDriver> {
    List<FlightDriver> getByFlight(int id);
}
