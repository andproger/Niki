package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("indication")
public class Indication {
    @IntPrimaryKey("id")
    private int id;
    @Column("indication_description")
    private String description;

    public Indication(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Indication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
