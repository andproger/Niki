package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Storage;

import java.util.ArrayList;

public interface StorageRepository {

    ArrayList<Storage> getStorages();

    void saveStorages(ArrayList<Storage> storages);
}
