package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Drug;
import com.niki.domain.entities.IntakeItem;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.gateways.repositories.IntakeItemRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntakeItemInteractorImpl implements IntakeItemInteractor {
    private final DrugRepository drugRepository;
    private final IntakeItemRepository intakeItemRepository;

    public IntakeItemInteractorImpl(DrugRepository drugRepository, IntakeItemRepository intakeItemRepository) {
        this.drugRepository = drugRepository;
        this.intakeItemRepository = intakeItemRepository;
    }

    @Override
    public ArrayList<IntakeItemContract> get() {
        var items = intakeItemRepository.get();
        var drugs = drugRepository.getDrugs();
        var contracts = new ArrayList<IntakeItemContract>();

        for (var item : items) {

            var drug = new Drug(item.getDrugId(), 0, 0, 0, 0, 0, "", "");
            var index = Collections.binarySearch(drugs, drug, Comparator.comparingInt(Drug::getId));
            drug = index >= 0 ? drugs.get(index) : null;

            contracts.add(new IntakeItemContract(item.getIntakeId(), drug, item.getQuantity(), item.getCost()));
        }

        return contracts;
    }

    @Override
    public ArrayList<Drug> getDrugs() {
        return drugRepository.getDrugs();
    }

    @Override
    public void save(ArrayList<IntakeItemContract> contracts) {
        var intakeItems = new ArrayList<IntakeItem>();

        for (var contract : contracts) {
            intakeItems.add(new IntakeItem(contract.getIntakeId(), contract.getDrug().getId(), contract.getQuantity(), contract.getCost()));
        }

        intakeItemRepository.save(intakeItems);
    }
}
