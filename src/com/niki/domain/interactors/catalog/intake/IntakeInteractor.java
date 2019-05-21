package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Provider;

import java.util.ArrayList;

public interface IntakeInteractor {
    ArrayList<IntakeContract> get();
    ArrayList<Provider> getProvider();

    void save(ArrayList<IntakeContract> contracts);
}
