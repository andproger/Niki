package com.niki.domain.entities;

public class IntakeItem {
    private int intakeId;
    private int drugId;
    private int quantity;
    private double cost;

    public IntakeItem(int intakeId, int drugId, int quantity) {
        this.intakeId = intakeId;
        this.drugId = drugId;
        this.quantity = quantity;
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
