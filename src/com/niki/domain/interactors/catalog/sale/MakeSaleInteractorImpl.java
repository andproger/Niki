package com.niki.domain.interactors.catalog.sale;

import com.niki.domain.entities.Sale;
import com.niki.domain.entities.SaleItem;
import com.niki.domain.gateways.repositories.SaleItemRepository;
import com.niki.domain.gateways.repositories.SaleRepository;
import com.niki.domain.gateways.repositories.UserAuthRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MakeSaleInteractorImpl implements MakeSaleInteractor {

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final UserAuthRepository userAuthRepository;

    public MakeSaleInteractorImpl(SaleRepository saleRepository, SaleItemRepository saleItemRepository, UserAuthRepository userAuthRepository) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public int add(List<SaleItemContract> contractItems) {
        int userId = userAuthRepository.getUser().getUserId();
        int newSaleId = saleRepository.save(new Sale(0, new Date(System.currentTimeMillis()), userId));

        setSaleIds(newSaleId, contractItems);
        saleItemRepository.save(contractsToItems(contractItems));

        return newSaleId;
    }

    @Override
    public void change(int saleId, List<SaleItemContract> contractItems) {
        setSaleIds(saleId, contractItems);

        saleItemRepository.deleteBySaleId(saleId);
        saleItemRepository.save(contractsToItems(contractItems));
    }

    @Override
    public void remove(int saleId) {
        saleItemRepository.deleteBySaleId(saleId);
        saleRepository.deleteById(saleId);
    }

    private void setSaleIds(int saleId, List<SaleItemContract> contractItems) {
        for (var item : contractItems) {
            item.setSaleId(saleId);
        }
    }

    private List<SaleItem> contractsToItems(List<SaleItemContract> contractItems) {
        var items = new ArrayList<SaleItem>();
        for (var contract : contractItems) {
            items.add(contractToItem(contract));
        }

        return items;
    }

    private SaleItem contractToItem(SaleItemContract contract) {
        return new SaleItem(
                contract.getSaleId(),
                contract.getDrug().getId(),
                contract.getQuantity(),
                contract.getDrug().getCost()
        );
    }
}
