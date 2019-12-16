package com.niki.domain.interactors.simpleView.bus;

import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.entities.Person;

import java.util.List;

public interface BusInteractor {
    List<BusContract> get();

    void save(List<BusContract> busContracts);

    List<BusModel> getModels();
    List<BusColor> getColors();
}
