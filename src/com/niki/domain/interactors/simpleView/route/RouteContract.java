package com.niki.domain.interactors.simpleView.route;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.Station;

public class RouteContract {
    int id;
    String name;
    Station fromStation;
    Station toStation;
    int distance;;

    public RouteContract(int id, String name, Station fromStation, Station toStation, int distance) {
        this.id = id;
        this.name = name;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public void setFromStation(Station fromStation) {
        this.fromStation = fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public void setToStation(Station toStation) {
        this.toStation = toStation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
