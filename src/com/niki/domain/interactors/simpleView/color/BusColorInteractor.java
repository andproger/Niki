package com.niki.domain.interactors.simpleView.color;

import com.niki.domain.entities.BusColor;

import java.util.List;

public interface BusColorInteractor {
    List<BusColor> get();

    void save(List<BusColor> items);
}
