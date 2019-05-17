package com.niki.data.repository;

import com.niki.domain.entities.Position;
import com.niki.domain.gateways.repositories.PositionRepository;

import java.util.ArrayList;

public class PositionRepositorySql implements PositionRepository {
    @Override
    public ArrayList<Position> getPositions() {
        var positions = new ArrayList<Position>();
        for (int i = 0; i < 10; i++)
            positions.add(new Position(i, 0, "TEST"));
        return positions;
    }

    @Override
    public void savePositions(ArrayList<Position> positions) {

    }
}
