package com.niki.domain.entities;

import com.niki.data.cache.database.annotaion.Table;

@Table("")
public class DrugCount {
    int count;

    public DrugCount() {
    }

    public DrugCount(int count) {
        this.count = count;
    }

    public int get() {
        return count;
    }

    public void set(int count) {
        this.count = count;
    }
}
