package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Drug;

public class SaleItemContract {
    private int saleId;
    private int quantity;
    private Drug drug;

    public SaleItemContract(int saleId, int quantity, Drug drug) {
        this.saleId = saleId;
        this.quantity = quantity;
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


    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
