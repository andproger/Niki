package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("ticket")
public class Ticket {
    @IntPrimaryKey("id")
    int id;
    @Column("purchase_time")
    int purchaseTime;
    @Column("flight_id")
    int flightId;
    @Column("seat")
    int seat;

    public Ticket() {
    }

    public Ticket(int id) {
        this.id = id;
    }

    public Ticket(int id, int purchaseTime, int flightId, int seat) {
        this.id = id;
        this.purchaseTime = purchaseTime;
        this.flightId = flightId;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
