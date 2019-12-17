package com.niki.domain.interactors.simpleView.station;

import com.niki.domain.entities.Station;

import java.util.List;

public interface StationInteractor {
    List<Station> get();

    void save(List<Station> stationContracts);
}
