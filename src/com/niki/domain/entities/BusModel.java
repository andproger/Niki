package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("bus_model")
public class BusModel {
    @IntPrimaryKey("id")
    int id;
    @Column("brand_id")
    int brandId;
    @Column("name")
    String name;
    @Column("power_reserve")
    int powerReserve;
    @Column("seats")
    int seats;

    public BusModel() {
    }

    public BusModel(int id) {
        this.id = id;
    }

    public BusModel(int id, int brandId, String name, int powerReserve, int seats) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.powerReserve = powerReserve;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerReserve() {
        return powerReserve;
    }

    public void setPowerReserve(int powerReserve) {
        this.powerReserve = powerReserve;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
