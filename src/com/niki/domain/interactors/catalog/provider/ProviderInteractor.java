package com.niki.domain.interactors.catalog.provider;

import java.util.List;

public interface ProviderInteractor {
    List<ProviderContract> get();

    void save(List<ProviderContract> providerContracts);
}
