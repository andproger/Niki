package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.FlightDriver;

import java.util.List;

public interface FlightDriverRepository {

    List<FlightDriver> get();

    List<FlightDriver> getByFlight(int id);

    FlightDriver get(int id);

    void save(List<FlightDriver> items);
}
