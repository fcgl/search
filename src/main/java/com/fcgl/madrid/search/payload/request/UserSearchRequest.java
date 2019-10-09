package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotNull;

public class UserSearchRequest {
    private Long userId;
    @NotNull
    private String query;

    public UserSearchRequest(Long userId, String query) {
        this.userId = userId;
        this.query = query;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
