package com.niki.domain.entities;

import com.niki.data.cache.annotaion.Column;
import com.niki.data.cache.annotaion.IntPrimaryKey;
import com.niki.data.cache.annotaion.Table;

@Table("form")
public class Form {
    @IntPrimaryKey("id")
    private int id;

    @Column("form_name")
    private String name;

    public Form(int id, String name) {
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
