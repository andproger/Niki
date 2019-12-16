package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Route;

import java.util.List;

public interface RouteRepository {

    List<Route> get();

    Route get(int id);

    void save(List<Route> items);
}
