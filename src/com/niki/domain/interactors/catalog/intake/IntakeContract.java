package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Provider;

public class IntakeContract {
    private int id;
    private Provider provider;
    private long dateTime;

    public IntakeContract() {
        this(0, null, 0);
    }

    public IntakeContract(int id, Provider provider, long dateTime) {
        this.id = id;
        this.provider = provider;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}
