package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;

@Table("position")
public class Position {

    @IntPrimaryKey("id")
    private int id;

    @Column("salary")
    private double salary;

    @Column("name")
    private String name;

    @Column("is_admin")
    private boolean admin;

    public Position() {

    }

    public Position(int id, double salary, String name, boolean admin) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return getName();
    }
}
