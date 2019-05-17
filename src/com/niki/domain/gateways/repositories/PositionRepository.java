package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Position;

import java.util.ArrayList;

public interface PositionRepository {

    ArrayList<Position> getPositions();

    void savePositions(ArrayList<Position> positions);
}
