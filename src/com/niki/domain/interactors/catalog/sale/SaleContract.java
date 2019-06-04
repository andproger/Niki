package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.User;

public class SaleContract {
    private int id;
    private long dateTime;
    private User user;

    public SaleContract(int id, long dateTime, User user) {
        this.id = id;
        this.dateTime = dateTime;
        this.user = user;
    }

    public SaleContract() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
