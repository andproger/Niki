package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Position;

import java.util.List;

public interface PositionRepository {

    List<Position> getPositions();

    void savePositions(List<Position> positions);
}
