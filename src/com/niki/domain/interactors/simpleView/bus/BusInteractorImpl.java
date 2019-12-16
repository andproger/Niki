package com.niki.domain.interactors.simpleView.bus;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusColor;
import com.niki.domain.entities.BusModel;
import com.niki.domain.gateways.repositories.BusColorRepository;
import com.niki.domain.gateways.repositories.BusModelRepository;
import com.niki.domain.gateways.repositories.BusRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusInteractorImpl implements BusInteractor {
    private final BusRepository busRepository;
    private final BusColorRepository busColorRepository;
    private final BusModelRepository busModelRepository;

    public BusInteractorImpl(BusRepository busRepository, BusColorRepository busColorRepository, BusModelRepository busModelRepository) {
        this.busRepository = busRepository;
        this.busColorRepository = busColorRepository;
        this.busModelRepository = busModelRepository;
    }

    @Override
    public List<BusContract> get() {
        var buses = busRepository.get();
        var busColors = busColorRepository.get();
        var busModels = busModelRepository.get();

        var busContracts = new ArrayList<BusContract>();
        for (var bus : buses) {
            var busColor = new BusColor(bus.getColorId());
            var index = Collections.binarySearch(busColors, busColor, Comparator.comparingInt(BusColor::getId));
            busColor = index >= 0 ? busColors.get(index) : null;

            var busModel = new BusModel(bus.getModelId());
            index = Collections.binarySearch(busModels, busModel, Comparator.comparingInt(BusModel::getId));
            busModel = index >= 0 ? busModels.get(index) : null;

            busContracts.add(new BusContract(
                    bus.getModelId(),
                    busColor,
                    busModel,
                    bus.getNumber()
            ));
        }

        return busContracts;
    }

    @Override
    public void save(List<BusContract> busContracts) {
        var buses = new ArrayList<Bus>();
        for (var contract : busContracts) {

            buses.add(new Bus(contract.getId(),
                    contract.getColor().getId(),
                    contract.getModel().getId(),
                    contract.getNumber()));
        }

        busRepository.save(buses);
    }

    @Override
    public List<BusModel> getModels() {
        return busModelRepository.get();
    }

    @Override
    public List<BusColor> getColors() {
        return busColorRepository.get();
    }

}
