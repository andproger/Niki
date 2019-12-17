package com.niki.domain.interactors.simpleView.route;

import com.niki.domain.entities.Route;
import com.niki.domain.entities.Station;
import com.niki.domain.gateways.repositories.RouteRepository;
import com.niki.domain.gateways.repositories.StationRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RouteInteractorImpl implements RouteInteractor {
    private final RouteRepository routeRepository;
    private final StationRepository stationRepository;


    public RouteInteractorImpl(RouteRepository routeRepository, StationRepository stationRepository) {
        this.routeRepository = routeRepository;
        this.stationRepository = stationRepository;
    }

    @Override
    public List<RouteContract> get() {
        var items = routeRepository.get();
        var stations = stationRepository.get();

        var busModelContracts = new ArrayList<RouteContract>();
        for (var item : items) {
            var stationFrom = new Station(item.getFromStationId());
            var index = Collections.binarySearch(stations, stationFrom, Comparator.comparingInt(Station::getId));
            stationFrom = index >= 0 ? stations.get(index) : null;

            var stationTo = new Station(item.getToStationId());
            index = Collections.binarySearch(stations, stationTo, Comparator.comparingInt(Station::getId));
            stationTo = index >= 0 ? stations.get(index) : null;

            busModelContracts.add(new RouteContract(
                    item.getId(),
                    item.getName(),
                    stationFrom,
                    stationTo,
                    item.getDistance()
            ));
        }

        return busModelContracts;
    }

    @Override
    public void save(List<RouteContract> routeContracts) {
        var routes = new ArrayList<Route>();
        for (var contract : routeContracts) {
            routes.add(new Route(
                    contract.getId(),
                    contract.getName(),
                    contract.fromStation.getId(),
                    contract.toStation.getId(),
                    contract.distance,
                    0));
        }

        routeRepository.save(routes);
    }

    @Override
    public List<Station> getStations() {
        return stationRepository.get();
    }

}
