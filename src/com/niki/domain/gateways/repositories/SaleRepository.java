package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Sale;

import java.util.List;

public interface SaleRepository {
    List<Sale> get();

    int save(Sale sale);

    void deleteById(int saleId);
}
