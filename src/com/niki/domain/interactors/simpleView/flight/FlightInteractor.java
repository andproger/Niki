package com.niki.domain.interactors.simpleView.flight;

import com.niki.domain.entities.*;

import java.util.List;

public interface FlightInteractor {
    List<FlightContract> get();

    void save(List<FlightContract> flightContracts);

    List<Route> getRoutes();
    List<Bus> getBuses();
    List<FlightDriver> getFlightDrivers();
    List<Driver> getDrivers();
}
