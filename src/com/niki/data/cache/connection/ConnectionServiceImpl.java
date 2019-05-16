package com.niki.data.cache.connection;

import com.niki.data.cache.Sql;
import com.niki.domain.gateways.connection.ConnectionService;

public class ConnectionServiceImpl implements ConnectionService {

    @Override
    public boolean checkConnection(String server) {
        if (hasConnection()) {
            //TODO: check current connection host
            return true;
        } else {
            Sql.init(server, "drugs", "admin", "admin");
            return hasConnection();
        }
    }

    @Override
    public boolean hasConnection() {
        return Sql.getIntent() != null && Sql.getIntent().getConnection() != null;
    }
}
