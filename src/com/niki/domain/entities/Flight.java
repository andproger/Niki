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

    public Flight() {
    }

    public Flight(int id) {
        this.id = id;
    }

    public Flight(int id, int busId, int routeId, double cost) {
        this.id = id;
        this.busId = busId;
        this.routeId = routeId;
        this.cost = cost;
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
}
