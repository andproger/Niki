package com.niki.domain.entities;

public class UserAuth {
    int userId;

    public UserAuth(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
