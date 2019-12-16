package com.niki.domain.interactors.simpleView.bus;

import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.entities.Person;

public class BusContract {
    private int id;
    private BusColor color;
    private BusModel model;
    private String number;

    public BusContract(int id, BusColor color, BusModel model, String number) {
        this.id = id;
        this.color = color;
        this.model = model;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusColor getColor() {
        return color;
    }

    public void setColor(BusColor color) {
        this.color = color;
    }

    public BusModel getModel() {
        return model;
    }

    public void setModel(BusModel model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return color.getName() + " " + number;
    }
}
