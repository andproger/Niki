package com.niki.domain.interactors.catalog.provider;

import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.ContactRepository;
import com.niki.domain.gateways.repositories.ProviderRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProviderInteractorImpl implements ProviderInteractor {
    private final ProviderRepository providerRepository;
    private final ContactRepository contactRepository;

    public ProviderInteractorImpl(ProviderRepository providerRepository, ContactRepository contactRepository) {
        this.providerRepository = providerRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ProviderContract> get() {
        return itemsToContracts(providerRepository.get());
    }

    @Override
    public void save(List<ProviderContract> providerContracts) {
        providerRepository.save(contractsToItems(providerContracts));
    }

    private List<ProviderContract> itemsToContracts(List<Provider> providers) {
        var contacts = contactRepository.get();

        var contracts = new ArrayList<ProviderContract>();
        for (var provider : providers) {
            var contact = new Contact(provider.getContactId() == null ? 0 : provider.getContactId());
            var index = Collections.binarySearch(contacts, contact, Comparator.comparingInt(Contact::getId));
            contact = index >= 0 ? contacts.get(index) : new Contact(0, "", "", "", "");

            contracts.add(new ProviderContract(provider.getId(), provider.getName(), contact));
        }

        return contracts;
    }


    private List<Provider> contractsToItems(List<ProviderContract> contracts) {
        var providers = new ArrayList<Provider>();

        for (var contract : contracts) {
            var contactId = contactRepository.save(contract.getContact());
            contract.getContact().setId(contactId);

            providers.add(new Provider(contract.getId(), contract.getName(), contactId != 0 ? contactId : null));
        }

        return providers;
    }
}
