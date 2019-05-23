package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Intake;
import com.niki.domain.entities.IntakeItem;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.IntakeItemRepository;
import com.niki.domain.gateways.repositories.IntakeRepository;
import com.niki.domain.gateways.repositories.ProviderRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class IntakeInteractorImpl implements IntakeInteractor {
    private final ProviderRepository providerRepository;
    private final IntakeRepository intakeRepository;
    private final IntakeItemRepository intakeItemRepository;

    public IntakeInteractorImpl(ProviderRepository providerRepository, IntakeRepository intakeRepository, IntakeItemRepository intakeItemRepository) {
        this.providerRepository = providerRepository;
        this.intakeRepository = intakeRepository;
        this.intakeItemRepository = intakeItemRepository;
    }


    @Override
    public int add(int providerId, List<IntakeItemContract> contractItems) {
        int newIntakeId = intakeRepository.save(new Intake(0, providerId, new Date(System.currentTimeMillis())));

        setIntakeIds(newIntakeId, contractItems);
        intakeItemRepository.save(contractsToItems(contractItems));

        return newIntakeId;
    }

    @Override
    public void change(int intakeId, List<IntakeItemContract> contractItems) {
        setIntakeIds(intakeId, contractItems);

        intakeItemRepository.deleteByIntakeId(intakeId);
        intakeItemRepository.save(contractsToItems(contractItems));
    }

    @Override
    public void remove(int intakeId) {
        intakeItemRepository.deleteByIntakeId(intakeId);
        intakeRepository.deleteById(intakeId);
    }

    private void setIntakeIds(int saleId, List<IntakeItemContract> contractItems) {
        for (var item : contractItems) {
            item.setIntakeId(saleId);
        }
    }

    private List<IntakeItem> contractsToItems(List<IntakeItemContract> contractItems) {
        var items = new ArrayList<IntakeItem>();
        for (var contract : contractItems) {
            items.add(contractToItem(contract));
        }

        return items;
    }

    private IntakeItem contractToItem(IntakeItemContract contract) {
        return new IntakeItem(
                contract.getIntakeId(),
                contract.getDrug().getId(),
                contract.getQuantity(),
                contract.getCost()
        );
    }



    @Override
    public List<Provider> getProvider() {
        return providerRepository.get();
    }
}
