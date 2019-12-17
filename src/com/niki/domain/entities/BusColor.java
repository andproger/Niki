package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("bus_color")
public class BusColor {
    @IntPrimaryKey("id")
    int id;
    @Column("name")
    String name;

    public BusColor() {
    }

    public BusColor(int id) {
        this.id = id;
    }

    public BusColor(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
