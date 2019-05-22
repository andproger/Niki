package com.niki.domain.interactors.catalog.sale;

public class SaleContract {
    private int id;
    private long dateTime;
    private int userId;

    public SaleContract() {
        this(0, 0, 0);
    }

    public SaleContract(int id, int userId, long dateTime) {
        this.id = id;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}
