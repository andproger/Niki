package com.niki.domain.entities;

import com.niki.data.cache.annotaion.Column;
import com.niki.data.cache.annotaion.IntPrimaryKey;
import com.niki.data.cache.annotaion.Table;

@Table("user")
public class User {
    @IntPrimaryKey("id")
    private int id;

    @Column("position_id")
    private int positionId;

    @Column("login")
    private String login;

    @Column("password")
    private String password;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    public User(int id, int positionId, String login, String password, String firstName, String lastName) {
        this.id = id;
        this.positionId = positionId;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return login;
    }
}
