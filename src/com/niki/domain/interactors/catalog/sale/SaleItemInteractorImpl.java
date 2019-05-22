package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Drug;
import com.niki.domain.entities.SaleItem;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.gateways.repositories.SaleItemRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SaleItemInteractorImpl implements SaleItemInteractor {
    private final DrugRepository drugRepository;
    private final SaleItemRepository saleItemRepository;

    public SaleItemInteractorImpl(DrugRepository drugRepository, SaleItemRepository saleItemRepository) {
        this.drugRepository = drugRepository;
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public ArrayList<SaleItemContract> getSaleItems() {
        var sales = saleItemRepository.getSaleItems();
        var drugs = drugRepository.getDrugs();
        var saleContracts = new ArrayList<SaleItemContract>();
        for (var s : sales) {
            var drug = new Drug(s.getSaleId(), 0, 0, 0, 0, 0, "", "");
            var index = Collections.binarySearch(drugs, drug, Comparator.comparingInt(Drug::getId));
            drug = index >= 0 ? drugs.get(index) : null;

            saleContracts.add(new SaleItemContract(s.getSaleId(), s.getQuantity(), s.getCost(), drug));
        }

        return saleContracts;
    }

    @Override
    public void saveSaleItems(ArrayList<SaleItemContract> saleItems) {
        var items = new ArrayList<SaleItem>();
        for (var contract : saleItems) {
            items.add(new SaleItem(contract.getSaleId(), contract.getDrug().getId(), contract.getQuantity(), contract.getCost()));
        }
        saleItemRepository.saveSaleItem(items);
    }

    @Override
    public ArrayList<Drug> getDrugs() {
        return drugRepository.getDrugs();
    }
}
