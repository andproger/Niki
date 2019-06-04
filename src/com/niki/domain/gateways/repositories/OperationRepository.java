package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Operation;

import java.util.List;

public interface OperationRepository {

    List<Operation> get();

    void save(List<Operation> operations);
}
