package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Drug;

public class SaleItemContract {
    private int saleId;
    private int quantity;
    private double cost;
    private Drug drug;

    public SaleItemContract(int saleId, int quantity, double cost, Drug drug) {
        this.saleId = saleId;
        this.quantity = quantity;
        this.cost = cost;
        this.drug = drug;
    }


    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
