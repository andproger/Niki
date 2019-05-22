package com.niki.data.cache.database.datastores.base;

import java.util.List;

public interface DataStore<T> {
    void save(List<T> items);

    List<T> getAll();
}
