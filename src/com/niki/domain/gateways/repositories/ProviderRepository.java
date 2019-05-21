package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Provider;

import java.util.ArrayList;

public interface ProviderRepository {

    ArrayList<Provider> get();

    void save(ArrayList<Provider> items);
}
