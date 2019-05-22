package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Provider;

import java.util.List;

public interface IntakeInteractor {
    List<IntakeContract> get();
    List<Provider> getProvider();

    void save(List<IntakeContract> contracts);
}
