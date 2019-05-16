package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;

public class Drug {
    private int id;
    private double cost;
    private String name;
    private String description;
    private DrugClass drugClass;
    private Manufacturer manufacturer;
    private Storage storage;
    private Form form;

    public Drug(int id, double cost, String name, String description, DrugClass drugClass, Manufacturer manufacturer, Storage storage, Form form) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.drugClass = drugClass;
        this.manufacturer = manufacturer;
        this.storage = storage;
        this.form = form;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DrugClass getDrugClass() {
        return drugClass;
    }

    public void setDrugClass(DrugClass drugClass) {
        this.drugClass = drugClass;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
