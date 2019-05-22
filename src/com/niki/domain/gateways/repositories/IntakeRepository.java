package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Intake;

import java.util.List;

public interface IntakeRepository {
    List<Intake> get();

    int save(Intake intake);

    void save(List<Intake> intakes);
}
