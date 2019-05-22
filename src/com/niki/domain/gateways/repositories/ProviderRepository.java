package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Provider;

import java.util.List;

public interface ProviderRepository {

    List<Provider> get();

    void save(List<Provider> items);
}
