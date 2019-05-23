package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Provider;

import java.util.List;

public interface IntakeInteractor {
    int add(int providerId, List<IntakeItemContract> contractItems);

    void change(int intakeId, List<IntakeItemContract> contractItems);

    void remove(int intakeId);

    List<Provider> getProvider();
}
