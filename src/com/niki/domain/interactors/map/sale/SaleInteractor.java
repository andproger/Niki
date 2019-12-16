package com.niki.domain.interactors.map.sale;

import com.niki.domain.interactors.simpleView.sale.SaleContract;
import com.niki.domain.interactors.simpleView.sale.SaleItemContract;

import java.util.ArrayList;
import java.util.List;

public interface SaleInteractor {

    ArrayList<SaleContract> get();

    ArrayList<SaleItemContract> getItems(int intakeId);

    List<Drug> getDrugs();
    List<User> getUsers();
}