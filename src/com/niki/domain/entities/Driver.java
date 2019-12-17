package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("driver")
public class Driver {
    @IntPrimaryKey("id")
    int id;
    @Column("person_id")
    int personId;
    @Column("id_card")
    String idCard;

    public Driver() {
    }

    public Driver(int id) {
        this.id = id;
    }

    public Driver(int id, int personId, String idCard) {
        this.id = id;
        this.personId = personId;
        this.idCard = idCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
