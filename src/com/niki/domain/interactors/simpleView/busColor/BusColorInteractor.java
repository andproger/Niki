package com.niki.domain.interactors.simpleView.busColor;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusColor;

import java.util.List;

public interface BusColorInteractor {
    List<BusColor> get();

    void save(List<BusColor> items);
}
