package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotNull;

public class UserId {

    @NotNull
    Long userId;

    public UserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "userId=" + userId +
                '}';
    }
}
