package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Provider;
import com.niki.domain.entities.Sale;
import com.niki.domain.gateways.repositories.IntakeRepository;
import com.niki.domain.gateways.repositories.ProviderRepository;
import com.niki.domain.gateways.repositories.SaleRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SaleInteractorImpl implements SaleInteractor {
    private final SaleRepository repository;

    public SaleInteractorImpl(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<SaleContract> get() {
        var items = repository.get();
        var contracts = new ArrayList<SaleContract>();

        for (var item : items) {
            contracts.add(new SaleContract(item.getId(), item.getUserId(), item.getDateTime().getTime()));
        }

        return contracts;
    }

    @Override
    public int save(SaleContract contract) {
        var sale = new Sale(contract.getId(), new Date(contract.getDateTime()), contract.getUserId());
        return repository.save(sale);
    }
}
