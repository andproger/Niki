package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.SaleItem;

import java.util.List;

public interface SaleItemRepository {
    List<SaleItem> get();

    void save(List<SaleItem> sales);

    void deleteBySaleId(int saleId);
}
