package com.fcgl.madrid.search.dataModel;

public class UserId {

    Long userId;

    public UserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "userId=" + userId +
                '}';
    }
}
