package com.niki.domain.entities;

import com.niki.data.cache.annotaion.Column;
import com.niki.data.cache.annotaion.Table;

@Table("intake_map")
public class IntakeItem {
    @Column("intake_id")
    private int intakeId;

    @Column("drug_id")
    private int drugId;

    @Column("quantity")
    private int quantity;

    @Column("cost")
    private double cost;

    public IntakeItem() {

    }

    public IntakeItem(int intakeId, int drugId, int quantity, double cost) {
        this.intakeId = intakeId;
        this.drugId = drugId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(int intakeId) {
        this.intakeId = intakeId;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "IntakeItem{" +
                "intakeId=" + intakeId +
                ", drugId=" + drugId +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
