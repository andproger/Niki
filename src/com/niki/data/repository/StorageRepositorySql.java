package com.niki.data.repository;

import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.StorageRepository;

import java.util.ArrayList;

public class StorageRepositorySql implements StorageRepository {

    @Override
    public ArrayList<Storage> getStorages() {
        var storages = new ArrayList<Storage>();
        for (int i = 0; i < 10; i++)
            storages.add(new Storage(i, "TEST"));
        return storages;
    }

    @Override
    public void saveStorages(ArrayList<Storage> storages) {

    }
}
