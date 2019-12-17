package com.niki.domain.interactors.simpleView.flight;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.Driver;
import com.niki.domain.entities.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class FlightContract {
    int id;
    Bus bus;
    Route route;
    double cost;
    ArrayList<Driver> drivers;
    LocalDateTime arrivalTime;
    LocalDateTime departureTime;

    public FlightContract(int id, Bus bus, Route route, double cost, ArrayList<Driver> drivers, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.id = id;
        this.bus = bus;
        this.route = route;
        this.cost = cost;
        this.drivers = drivers;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return route != null ? route.toString() : "";
    }
}
