package com.niki.domain.interactors.simpleView.busBrand;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;

import java.util.List;

public interface BusBrandInteractor {
    List<BusBrand> get();

    void save(List<BusBrand> busContracts);
}
