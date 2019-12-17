package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("bus")
public class Bus {
    @IntPrimaryKey("id")
    int id;
    @Column("color_id")
    int colorId;
    @Column("model_id")
    int modelId;
    @Column("number")
    String number;

    public Bus() {
    }

    public Bus(int id) {
        this.id = id;
    }

    public Bus(int id, int colorId, int modelId, String number) {
        this.id = id;
        this.colorId = colorId;
        this.modelId = modelId;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
