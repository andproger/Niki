package com.niki.domain.gateways.connection;

public interface ConnectionService {
    boolean checkConnection(String server);

    boolean hasConnection();
}
