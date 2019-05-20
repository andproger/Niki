package com.niki.data.cache.connection;

import com.niki.data.cache.Sql;
import com.niki.domain.entities.ConnectionSettings;
import com.niki.domain.gateways.connection.ConnectionService;
import com.niki.domain.gateways.repositories.ConnectionSettingsRepository;

public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionSettingsRepository settingsRepository;

    public ConnectionServiceImpl(ConnectionSettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Override
    public boolean checkConnection(String server) {
        ConnectionSettings settings = settingsRepository.get();

        if (hasConnection() && settings.getHost().equals(server)) {
            return true;
        } else {
            Sql.init(server, settings.getDatabase(), settings.getUser(), settings.getPassword());
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
        return Sql.getIntent() != null && Sql.getIntent().getConnection() != null;
    }
}
