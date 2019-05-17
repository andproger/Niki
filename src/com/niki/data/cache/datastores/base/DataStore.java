package com.niki.data.cache.datastores.base;

import java.util.ArrayList;

public interface DataStore<T> {
    void save(ArrayList<T> items);

    ArrayList<T> getAll();
}
