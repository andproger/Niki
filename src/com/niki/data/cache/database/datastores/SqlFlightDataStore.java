package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Flight;
import com.niki.domain.entities.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlFlightDataStore extends SqlDataStore<Flight> implements FlightDataStore {

    public SqlFlightDataStore() {
        super(Flight.class);
    }

    @Override
    protected Flight newItemInstance() {
        return new Flight();
    }
}