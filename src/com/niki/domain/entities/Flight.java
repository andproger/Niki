package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("flight")
public class Flight {
    @IntPrimaryKey("id")
    int id;
    @Column("bus_id")
    int busId;
    @Column("route_id")
    int routeId;
    @Column("cost")
    double cost;
    @Column("departure_time")
    long departureTime;
    @Column("arrival_time")
    long arrivalTime;

    public Flight() {
    }

    public Flight(int id) {
        this.id = id;
    }

    public Flight(int id, int busId, int routeId, double cost, long departureTime, long arrivalTime) {
        this.id = id;
        this.busId = busId;
        this.routeId = routeId;
        this.cost = cost;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
