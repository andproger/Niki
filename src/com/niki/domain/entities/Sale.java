package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("sales")
public class Sale {
    @IntPrimaryKey("id")
    private int id;

    @Column("time")
    private int dateTime;

    @Column("user_id")
    private int userId;

    public Sale(int id, int dateTime, int userId) {
        this.id = id;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
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
