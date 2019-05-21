package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Drug;

public class IntakeItemContract {
    private int intakeId;
    private Drug drug;
    private int quantity;
    private double cost;

    public IntakeItemContract() {
        this(0, null, 0, 0);
    }

    public IntakeItemContract(int intakeId, Drug drug, int quantity, double cost) {
        this.intakeId = intakeId;
        this.drug = drug;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(int intakeId) {
        this.intakeId = intakeId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
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
}
