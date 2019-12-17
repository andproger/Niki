package com.niki.domain.interactors.simpleView.color;

import com.niki.domain.entities.BusColor;
import com.niki.domain.gateways.repositories.BusColorRepository;

import java.util.List;

public class BusColorInteractorImpl implements BusColorInteractor {
    private final BusColorRepository busColorRepository;

    public BusColorInteractorImpl(BusColorRepository busColorRepository) {
        this.busColorRepository = busColorRepository;
    }

    @Override
    public List<BusColor> get() {
        return busColorRepository.get();
    }

    @Override
    public void save(List<BusColor> items) {
       busColorRepository.save(items);
    }
}
