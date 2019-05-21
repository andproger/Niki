package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Intake;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.IntakeRepository;
import com.niki.domain.gateways.repositories.ProviderRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntakeInteractorImpl implements IntakeInteractor {
    private final ProviderRepository providerRepository;
    private final IntakeRepository intakeRepository;

    public IntakeInteractorImpl(ProviderRepository providerRepository, IntakeRepository intakeRepository) {
        this.providerRepository = providerRepository;
        this.intakeRepository = intakeRepository;
    }

    @Override
    public ArrayList<IntakeContract> get() {
        var items = intakeRepository.get();
        var providers = providerRepository.get();
        var contracts = new ArrayList<IntakeContract>();

        for (var item : items) {

            var provider = new Provider(item.getProviderId(), "", "");
            var index = Collections.binarySearch(providers, provider, Comparator.comparingInt(Provider::getId));
            provider = index >= 0 ? providers.get(index) : null;

            contracts.add(new IntakeContract(item.getId(), provider, item.getDateTime()));
        }

        return contracts;
    }

    @Override
    public ArrayList<Provider> getProvider() {
        return providerRepository.get();
    }

    @Override
    public void save(ArrayList<IntakeContract> contracts) {
        var intakes = new ArrayList<Intake>();

        for (var contract : contracts) {
            intakes.add(new Intake(contract.getId(), contract.getProvider().getId(), contract.getDateTime()));
        }

        intakeRepository.save(intakes);
    }
}
