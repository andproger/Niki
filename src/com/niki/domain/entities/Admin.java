package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("admin")
public class Admin {
    @IntPrimaryKey("id")
    int id;
    @Column("person_id")
    int personId;
    @Column("login")
    String login;
    @Column("password")
    String password;

    public Admin() {
    }

    public Admin(int id) {
        this.id = id;
    }

    public Admin(int id, int personId, String login, String password) {
        this.id = id;
        this.personId = personId;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
