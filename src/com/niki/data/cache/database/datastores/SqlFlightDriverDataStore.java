package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Flight;
import com.niki.domain.entities.FlightDriver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlFlightDriverDataStore extends SqlDataStore<FlightDriver> implements FlightDriverDataStore {

    public SqlFlightDriverDataStore() {
        super(FlightDriver.class);
    }

    @Override
    protected FlightDriver newItemInstance() {
        return new FlightDriver();
    }

    @Override
    public List<FlightDriver> getByFlight(int id) {
        var flightDrivers = new ArrayList<FlightDriver>();

        try {
            var statement = connection.prepareStatement(sqlGen.select("where flight_id = " + id, null));
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flightDrivers.add(new FlightDriver(
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("driver_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightDrivers;
    }
}

