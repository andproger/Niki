package com.niki.domain.interactors.map.sale;

import com.niki.domain.entities.Drug;
import com.niki.domain.entities.Sale;
import com.niki.domain.entities.SaleItem;
import com.niki.domain.entities.User;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.gateways.repositories.SaleItemRepository;
import com.niki.domain.gateways.repositories.SaleRepository;
import com.niki.domain.gateways.repositories.UserRepository;
import com.niki.domain.interactors.catalog.sale.SaleContract;
import com.niki.domain.interactors.catalog.sale.SaleItemContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SaleInteractorImpl implements SaleInteractor {
    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final UserRepository userRepository;
    private final DrugRepository drugRepository;

    public SaleInteractorImpl(SaleRepository saleRepository, SaleItemRepository saleItemRepository, UserRepository userRepository, DrugRepository drugRepository) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.userRepository = userRepository;
        this.drugRepository = drugRepository;
    }

    @Override
    public ArrayList<SaleContract> get() {
        return intakesToContracts(saleRepository.get());
    }

    @Override
    public ArrayList<SaleItemContract> getItems(int saleId) {
        return saleItemsToContracts(saleItemRepository.get(saleId));
    }

    @Override
    public List<Drug> getDrugs() {
        return drugRepository.getDrugs();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.get();
    }

    private ArrayList<SaleContract> intakesToContracts(List<Sale> sales) {
        var users = userRepository.get();
        var contracts = new ArrayList<SaleContract>();

        for (var sale : sales) {
            contracts.add(saleToContract(users, sale));
        }
        return contracts;
    }

    private SaleContract saleToContract(List<User> users, Sale sale) {
        var user = new User();
        user.setId(sale.getUserId());
        var index = Collections.binarySearch(users, user, Comparator.comparingInt(User::getId));
        user = index >= 0 ? users.get(index) : null;

        return new SaleContract(sale.getId(), sale.getDateTime().getTime(), user);
    }

    private ArrayList<SaleItemContract> saleItemsToContracts(List<SaleItem> items) {
        var drugs = drugRepository.getDrugs();
        var contracts = new ArrayList<SaleItemContract>();

        for (var item : items) {
            contracts.add(saleItemToContract(drugs, item));
        }
        return contracts;
    }

    private SaleItemContract saleItemToContract(List<Drug> drugs, SaleItem item) {
        var drug = new Drug();
        drug.setId(item.getDrugId());
        var index = Collections.binarySearch(drugs, drug, Comparator.comparingInt(Drug::getId));
        drug = index >= 0 ? drugs.get(index) : null;

        return new SaleItemContract(item.getSaleId(), item.getQuantity(), drug);
    }
}
