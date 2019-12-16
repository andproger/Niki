package com.niki.domain.interactors.simpleView.model;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;

public class BusModelContract {
    private int id;
    private BusBrand brand;
    private String name;
    private int powerReserve;
    private int seats;

    public BusModelContract(int id, BusBrand brand, String name, int powerReserve, int seats) {
        this.id = id;
        this.brand = brand;
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

    public BusBrand getBrand() {
        return brand;
    }

    public void setBrand(BusBrand brand) {
        this.brand = brand;
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

    @Override
    public String toString() {
        return name;
    }
}
