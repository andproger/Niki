package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

import java.sql.Timestamp;

@Table("sales")
public class Sale {
    @IntPrimaryKey("id")
    private int id;

    @Column("time")
    private Timestamp dateTime;

    @Column("user_id")
    private int userId;

    public Sale(int id, Timestamp dateTime, int userId) {
        this.id = id;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public Sale() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", userId=" + userId +
                '}';
    }
}
