package com.niki.domain.interactors.simpleView.route;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.Station;

import java.util.List;

public interface RouteInteractor {
    List<RouteContract> get();

    void save(List<RouteContract> routeContracts);

    List<Station> getStations();
}
