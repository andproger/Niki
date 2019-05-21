package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Intake;
import com.niki.domain.entities.SaleItem;

import java.util.ArrayList;

public interface IntakeRepository {
    ArrayList<Intake> get();

    int save(Intake intake);
    void save(ArrayList<Intake> intakes);
}
