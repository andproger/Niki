package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

import java.sql.Date;

@Table("intake_drug")
public class Intake {
    @IntPrimaryKey("id")
    private int id;

    @Column("provider_id")
    private int providerId;

    @Column("date")
    private Date dateTime;

    public Intake() {

    }

    public Intake(int id, int providerId, Date dateTime) {
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
