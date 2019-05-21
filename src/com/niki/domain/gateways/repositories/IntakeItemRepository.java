package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Intake;
import com.niki.domain.entities.IntakeItem;

import java.util.ArrayList;

public interface IntakeItemRepository {
    ArrayList<IntakeItem> get();
    ArrayList<IntakeItem> get(int intakeId);
    void save(ArrayList<IntakeItem> items);
}
