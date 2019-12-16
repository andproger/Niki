package com.niki.domain.interactors.simpleView.model;

import com.niki.domain.entities.BusBrand;
import com.niki.domain.entities.BusModel;
import com.niki.domain.gateways.repositories.BusBrandRepository;
import com.niki.domain.gateways.repositories.BusModelRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusModelModelInteractorImpl implements BusModelInteractor {
    private final BusModelRepository busModelRepository;
    private final BusBrandRepository busBrandRepository;

    public BusModelModelInteractorImpl(BusModelRepository busModelRepository, BusBrandRepository busBrandRepository) {
        this.busModelRepository = busModelRepository;
        this.busBrandRepository = busBrandRepository;
    }


    @Override
    public List<BusModelContract> get() {
        var items = busModelRepository.get();
        var busBrands = busBrandRepository.get();

        var busModelContracts = new ArrayList<BusModelContract>();
        for (var bus : items) {
            var busBrand = new BusBrand(bus.getBrandId());
            var index = Collections.binarySearch(busBrands, busBrand, Comparator.comparingInt(BusBrand::getId));
            busBrand = index >= 0 ? busBrands.get(index) : null;

            busModelContracts.add(new BusModelContract(
                    bus.getId(),
                    busBrand,
                    bus.getName(),
                    bus.getPowerReserve(),
                    bus.getSeats()
            ));
        }

        return busModelContracts;
    }

    @Override
    public void save(List<BusModelContract> busModelContracts) {
        var models = new ArrayList<BusModel>();
        for (var contract : busModelContracts) {
            models.add(new BusModel(contract.getId(),
                    contract.getBrand().getId(),
                    contract.getName(),
                    contract.getPowerReserve(),
                    contract.getSeats()));
        }

        busModelRepository.save(models);
    }

    @Override
    public List<BusBrand> getBrands() {
        return busBrandRepository.get();
    }


}
