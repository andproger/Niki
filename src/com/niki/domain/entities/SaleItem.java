package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.Table;

@Table("sales_map")
public class SaleItem {

    @Column("sale_id")
    private int saleId;

    @Column("drug_id")
    private int drugId;

    @Column("quantity")
    private int quantity;

    @Column("cost")
    private double cost;

    public SaleItem() {

    }

    public SaleItem(int saleId, int drugId, int quantity, double cost) {
        this.saleId = saleId;
        this.drugId = drugId;
        this.quantity = quantity;
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
        return "SaleItem{" +
                "saleId=" + saleId +
                ", drugId=" + drugId +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
