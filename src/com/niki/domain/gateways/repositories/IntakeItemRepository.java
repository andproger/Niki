package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.IntakeItem;

import java.util.List;

public interface IntakeItemRepository {
    List<IntakeItem> get();

    List<IntakeItem> get(int intakeId);

    void save(List<IntakeItem> items);
}
