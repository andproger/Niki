package com.niki.domain.entities;

import com.niki.data.cache.annotaion.Column;
import com.niki.data.cache.annotaion.IntPrimaryKey;
import com.niki.data.cache.annotaion.Table;

@Table("position")
public class Position {

    @IntPrimaryKey("id")
    private int id;

    @Column("salary")
    private double salary;

    @Column("name")
    private String name;

    public Position() {

    }

    public Position(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
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

    @Override
    public String toString() {
        return getName();
    }
}
