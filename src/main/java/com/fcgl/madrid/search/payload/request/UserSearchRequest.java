package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

public class UserSearchRequest {
    @NotNull
    private Long userId;
    @NotEmpty
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
