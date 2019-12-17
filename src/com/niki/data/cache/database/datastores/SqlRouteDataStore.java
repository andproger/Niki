package com.niki.data.cache.database.datastores;

import com.niki.data.cache.database.datastores.base.SqlDataStore;
import com.niki.domain.entities.Route;

public class SqlRouteDataStore extends SqlDataStore<Route> implements RouteDataStore {

    public SqlRouteDataStore() {
        super(Route.class);
    }

    @Override
    protected Route newItemInstance() {
        return new Route();
    }
}
