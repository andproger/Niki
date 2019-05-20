package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.ConnectionSettings;

public interface ConnectionSettingsRepository {

    ConnectionSettings get();

    void save(ConnectionSettings settings);
}
