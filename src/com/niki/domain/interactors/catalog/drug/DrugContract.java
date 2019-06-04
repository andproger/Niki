package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.*;

public class DrugContract {
    private int id;
    private double cost;
    private String name;
    private String description;
    private DrugClass drugClass;
    private Manufacturer manufacturer;
    private Storage storage;
    private Form form;
    private DrugCount drugCount;

    public DrugContract(
            int id,
            double cost,
            String name,
            String description,
            DrugClass drugClass,
            Manufacturer manufacturer,
            Storage storage,
            Form form,
            DrugCount drugCount
    ) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.drugClass = drugClass;
        this.manufacturer = manufacturer;
        this.storage = storage;
        this.form = form;
        this.drugCount = drugCount;
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

    public DrugCount getDrugCount() {
        return drugCount;
    }

    public void setDrugCount(DrugCount drugCount) {
        this.drugCount = drugCount;
    }

    @Override
    public String toString() {
        return name;
    }
}
