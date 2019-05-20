package com.niki.domain.entities;

public class SaleItem {
    private int saleId;
    private int drugId;
    private int quantiy;
    private double cost;

    public SaleItem() {

    }

    public SaleItem(int saleId, int drugId, int quantiy, double cost) {
        this.saleId = saleId;
        this.drugId = drugId;
        this.quantiy = quantiy;
        this.cost = cost;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "saleId=" + saleId +
                ", drugId=" + drugId +
                ", quantiy=" + quantiy +
                ", cost=" + cost +
                '}';
    }
}
