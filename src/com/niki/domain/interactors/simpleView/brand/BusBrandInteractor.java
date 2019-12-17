package com.niki.domain.interactors.simpleView.brand;

import com.niki.domain.entities.BusBrand;

import java.util.List;

public interface BusBrandInteractor {
    List<BusBrand> get();

    void save(List<BusBrand> busContracts);
}
