package com.niki.domain.interactors.simpleView.model;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;

import java.util.List;

public interface BusModelInteractor {
    List<BusModelContract> get();

    void save(List<BusModelContract> busModelContracts);

    List<BusBrand> getBrands();
}
