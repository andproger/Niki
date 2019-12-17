package com.niki.domain.interactors.simpleView.flight;

import com.niki.domain.entities.*;
import com.niki.domain.gateways.repositories.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class FlightInteractorImpl implements FlightInteractor {
    private final FlightRepository flightRepository;
    private final RouteRepository routeRepository;
    private final FlightDriverRepository flightDriverRepository;
    private final DriverRepository driverRepository;
    private final BusRepository busRepository;

    public FlightInteractorImpl(FlightRepository flightRepository, RouteRepository routeRepository, FlightDriverRepository flightDriverRepository, DriverRepository driverRepository, BusRepository busRepository) {
        this.flightRepository = flightRepository;
        this.routeRepository = routeRepository;
        this.flightDriverRepository = flightDriverRepository;
        this.driverRepository = driverRepository;
        this.busRepository = busRepository;
    }

    @Override
    public List<FlightContract> get() {
        var drivers = driverRepository.get();
        var flights = flightRepository.get();
        var routes = routeRepository.get();
        var flightDrivers = flightDriverRepository.get();
        var buses = busRepository.get();

        var flightContracts = new ArrayList<FlightContract>();
        for (var item : flights) {
            var route = new Route(item.getRouteId());
            var index = Collections.binarySearch(routes, route, Comparator.comparingInt(Route::getId));
            route = index >= 0 ? routes.get(index) : null;

            var bus = new Bus(item.getBusId());
            index = Collections.binarySearch(buses, bus, Comparator.comparingInt(Bus::getId));
            bus = index >= 0 ? buses.get(index) : null;

            var drivers1 = new ArrayList<Driver>();
            for (var flightDriver : flightDrivers) {
                if (flightDriver.getFlightId() == item.getId()) {
                    var driver = new Driver(flightDriver.getDriverId());
                    index = Collections.binarySearch(drivers, driver, Comparator.comparingInt(Driver::getId));
                    driver = index >= 0 ? drivers.get(index) : null;
                    drivers1.add(driver);
                }
            }

            flightContracts.add(new FlightContract(
                    item.getId(),
                    bus,
                    route,
                    item.getCost(),
                    drivers1,
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(item.getArrivalTime()),
                            TimeZone.getDefault().toZoneId()),
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(item.getDepartureTime()),
                            TimeZone.getDefault().toZoneId()))
            );
        }

        return flightContracts;
    }

    @Override
    public void save(List<FlightContract> flightContracts) {
        var flights = new ArrayList<Flight>();
        var flightDrivers = new ArrayList<FlightDriver>();

        for (var contract : flightContracts) {

            for (var driver : contract.drivers)
                flightDrivers.add(new FlightDriver(contract.id, driver.getId()));

            ZoneId zoneId = TimeZone.getDefault().toZoneId();

            flights.add(new Flight(
                    contract.getId(),
                    contract.bus != null? contract.bus.getId() : 0,
                    contract.route != null? contract.route.getId() : 0,
                    contract.cost,
                    contract.departureTime.atZone(zoneId).toEpochSecond(),
                    contract.arrivalTime.atZone(zoneId).toEpochSecond()
            ));
        }

        flightRepository.save(flights);
        flightDriverRepository.save(flightDrivers);
    }

    @Override
    public List<Route> getRoutes() {
        return routeRepository.get();
    }

    @Override
    public List<Bus> getBuses() {
        return busRepository.get();
    }

    @Override
    public List<FlightDriver> getFlightDrivers() {
        return flightDriverRepository.get();
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.get();
    }


}
