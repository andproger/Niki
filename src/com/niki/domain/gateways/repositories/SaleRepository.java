package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Intake;
import com.niki.domain.entities.Sale;

import java.util.ArrayList;

public interface SaleRepository {
    ArrayList<Sale> get();

    int save(Sale sale);
}
