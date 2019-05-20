package com.niki.domain.entities;

import com.niki.data.cache.annotaion.Column;
import com.niki.data.cache.annotaion.IntPrimaryKey;
import com.niki.data.cache.annotaion.Table;

@Table("drug")
public class Drug {

    @IntPrimaryKey("id")
    private int id;

    @Column("drug_class_id")
    private int classId;

    @Column("manufacturer_id")
    private int manufacturerId;

    @Column("storage_id")
    private int storageId;

    @Column("form_id")
    private int formId;

    @Column("cost")
    private double cost;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    public Drug() {
    }

    public Drug(int id, double cost, int classId, int manufacturerId, int starageId, int formId, String name, String description) {
        this.id = id;
        this.cost = cost;
        this.classId = classId;
        this.manufacturerId = manufacturerId;
        this.storageId = starageId;
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

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
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
