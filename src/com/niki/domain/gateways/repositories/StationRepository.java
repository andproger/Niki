package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Station;

import java.util.List;

public interface StationRepository {

    List<Station> get();

    Station get(int id);

    void save(List<Station> items);
}
