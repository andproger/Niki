package com.niki.domain.interactors.simpleView.station;

import com.niki.domain.entities.Station;
import com.niki.domain.gateways.repositories.StationRepository;

import java.util.List;

public class StationInteractorImpl implements StationInteractor {
    private final StationRepository stationRepository;

    public StationInteractorImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public List<Station> get() {
        return stationRepository.get();
    }

    @Override
    public void save(List<Station> items) {
        stationRepository.save(items);
    }

}
