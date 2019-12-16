package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.Table;

@Table("flight_driver")
public class FlightDriver {
    @Column("flight_id")
    int flightId;
    @Column("driver_id")
    int driverId;

    public FlightDriver() {
    }

    public FlightDriver(int flightId) {
        this.flightId = flightId;
    }

    public FlightDriver(int flightId, int driverId) {
        this.flightId = flightId;
        this.driverId = driverId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
