package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("route")
public class Route {
    @IntPrimaryKey("id")
    int id;
    @Column("name")
    String name;
    @Column("from_station_id")
    int fromStationId;
    @Column("to_station_id")
    int toStationId;
    @Column("distance")
    int distance;
    @Column("type")
    int type;

    public Route() {
    }

    public Route(int id) {
        this.id = id;
    }

    public Route(int id, String name, int fromStationId, int toStationId, int distance, int type) {
        this.id = id;
        this.name = name;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.distance = distance;
        this.type = type;
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

    public int getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(int fromStationId) {
        this.fromStationId = fromStationId;
    }

    public int getToStationId() {
        return toStationId;
    }

    public void setToStationId(int toStationId) {
        this.toStationId = toStationId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
