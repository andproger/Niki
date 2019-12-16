package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Admin;

import java.util.List;

public interface AdminRepository {

    List<Admin> get();

    Admin get(int userId);

    void save(List<Admin> users);
}
