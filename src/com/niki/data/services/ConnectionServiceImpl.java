package com.niki.data.services;

import com.niki.data.cache.database.connection.SqlConnector;
import com.niki.domain.gateways.connection.ConnectionService;

public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionSettingsRepository settingsRepository;

    public ConnectionServiceImpl(ConnectionSettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Override
    public boolean checkConnection(String server) {
        ConnectionSettings settings = settingsRepository.get();
        if (settings == null) {
            settings = getDefault();
        }

        if (hasConnection() && settings.getHost().equals(server)) {
            return true;
        } else {
            SqlConnector.init(server, settings.getDatabase(), settings.getUser(), settings.getPassword());
            boolean connected = hasConnection();
            if (connected) {
                settings.setHost(server);
                settingsRepository.save(settings);
            }
            return connected;
        }
    }

    @Override
    public boolean hasConnection() {
        return SqlConnector.getIntent() != null && SqlConnector.getIntent().getConnection() != null;
    }

    private static ConnectionSettings getDefault() {
        return new ConnectionSettings(
                "VSS",
                "drugs",
                "admin",
                "admin"
        );
    }
}
