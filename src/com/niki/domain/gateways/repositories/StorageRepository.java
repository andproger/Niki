package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Storage;

import java.util.List;

public interface StorageRepository {

    List<Storage> getStorages();

    void saveStorages(List<Storage> storages);
}
