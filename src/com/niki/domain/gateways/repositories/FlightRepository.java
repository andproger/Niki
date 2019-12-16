package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Flight;

import java.util.List;

public interface FlightRepository {

    List<Flight> get();

    Flight get(int id);

    void save(List<Flight> items);
}
