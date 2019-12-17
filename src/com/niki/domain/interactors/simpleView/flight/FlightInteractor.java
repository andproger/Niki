package com.niki.domain.interactors.simpleView.flight;

import com.niki.domain.entities.FlightDriver;
import com.niki.domain.entities.Route;
import com.niki.domain.entities.Station;

import java.util.List;

public interface FlightInteractor {
    List<FlightContract> get();

    void save(List<FlightContract> flightContracts);

    List<Route> getRoutes();
    List<FlightDriver> getFlightDrivers();
}
