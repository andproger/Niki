package com.niki.data.repository;

import com.niki.domain.entities.ConnectionSettings;
import com.niki.domain.gateways.repositories.ConnectionSettingsRepository;

public class ConnectionSettingsJsonRepository implements ConnectionSettingsRepository {

    @Override
    public ConnectionSettings get() {
        //TODO: implement
        return new ConnectionSettings(
                "VVS",
                "drugs",
                "admin",
                "admin"
        );
    }

    @Override
    public void save(ConnectionSettings settings) {

    }
}
