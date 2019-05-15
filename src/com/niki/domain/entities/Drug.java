package com.niki.domain.entities;

public class Drug {
    private int id;
    private int classId;
    private int manufacturerId;
    private int starageId;
    private int formId;
    private double cost;
    private String name;
    private String description;

    public Drug(int id, int classId, int manufacturerId, int starageId, int formId, String name, String description) {
        this.id = id;
        this.classId = classId;
        this.manufacturerId = manufacturerId;
        this.starageId = starageId;
        this.formId = formId;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getStarageId() {
        return starageId;
    }

    public void setStarageId(int starageId) {
        this.starageId = starageId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
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

    @Override
    public String toString() {
        return name;
    }
}
