package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

import java.sql.Date;

@Table("operations")
public class Operation {
    @IntPrimaryKey("id")
    private int id;

    @Column("description")
    private String description;

    @Column("date_time")
    private Date dateTime;

    public Operation() {
    }

    public Operation(int id, String description, Date dateTime) {
        this.id = id;
        this.description = description;
        this.dateTime = dateTime;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return description;
    }

}
