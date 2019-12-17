package com.niki.domain.interactors.simpleView.brand;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.gateways.repositories.BusBrandRepository;

import java.util.List;

public class BusBrandInteractorImpl implements BusBrandInteractor {
    private final BusBrandRepository busBrandRepository;

    public BusBrandInteractorImpl(BusBrandRepository busBrandRepository) {
        this.busBrandRepository = busBrandRepository;
    }

    @Override
    public List<BusBrand> get() {
        return busBrandRepository.get();
    }

    @Override
    public void save(List<BusBrand> items) {
       busBrandRepository.save(items);
    }
}
