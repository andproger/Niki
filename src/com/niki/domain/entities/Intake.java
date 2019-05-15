package com.niki.domain.entities;

public class Intake {
    private int id;
    private int providerId;
    private int dateTime;

    public Intake(int id, int providerId, int dateTime) {
        this.id = id;
        this.providerId = providerId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Intake{" +
                "id=" + id +
                ", providerId=" + providerId +
                ", dateTime=" + dateTime +
                '}';
    }
}
