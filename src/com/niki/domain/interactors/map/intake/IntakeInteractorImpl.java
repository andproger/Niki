package com.niki.domain.interactors.map.intake;

import com.niki.domain.entities.Drug;
import com.niki.domain.entities.Intake;
import com.niki.domain.entities.IntakeItem;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.gateways.repositories.IntakeItemRepository;
import com.niki.domain.gateways.repositories.IntakeRepository;
import com.niki.domain.gateways.repositories.ProviderRepository;
import com.niki.domain.interactors.catalog.intake.IntakeContract;
import com.niki.domain.interactors.catalog.intake.IntakeItemContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntakeInteractorImpl implements IntakeInteractor {
    private final IntakeRepository intakeRepository;
    private final IntakeItemRepository intakeItemRepository;
    private final ProviderRepository providerRepository;
    private final DrugRepository drugRepository;

    public IntakeInteractorImpl(IntakeRepository intakeRepository, IntakeItemRepository intakeItemRepository, ProviderRepository providerRepository, DrugRepository drugRepository) {
        this.intakeRepository = intakeRepository;
        this.intakeItemRepository = intakeItemRepository;
        this.providerRepository = providerRepository;
        this.drugRepository = drugRepository;
    }

    @Override
    public ArrayList<IntakeContract> get() {
        return intakesToContracts(intakeRepository.get());
    }

    @Override
    public ArrayList<IntakeItemContract> getItems(int intakeId) {
        return intakeItemsToContracts(intakeItemRepository.get(intakeId));
    }

    private ArrayList<IntakeContract> intakesToContracts(List<Intake> intakes) {
        var providers = providerRepository.get();
        var contracts = new ArrayList<IntakeContract>();

        for (var intake : intakes) {
            contracts.add(intakeToContract(providers, intake));
        }
        return contracts;
    }

    private IntakeContract intakeToContract(List<Provider> providers, Intake intake) {
        var provider = new Provider();
        provider.setId(intake.getProviderId());
        var index = Collections.binarySearch(providers, provider, Comparator.comparingInt(Provider::getId));
        provider = index >= 0 ? providers.get(index) : null;

        return new IntakeContract(intake.getId(), provider, intake.getDateTime().getTime());
    }

    private ArrayList<IntakeItemContract> intakeItemsToContracts(List<IntakeItem> items) {
        var drugs = drugRepository.getDrugs();
        var contracts = new ArrayList<IntakeItemContract>();

        for (var item : items) {
            contracts.add(intakeItemToContract(drugs, item));
        }
        return contracts;
    }

    private IntakeItemContract intakeItemToContract(List<Drug> drugs, IntakeItem item) {
        var drug = new Drug();
        drug.setId(item.getDrugId());
        var index = Collections.binarySearch(drugs, drug, Comparator.comparingInt(Drug::getId));
        drug = index >= 0 ? drugs.get(index) : null;

        return new IntakeItemContract(item.getIntakeId(), drug, item.getQuantity(), item.getCost());
    }
}
