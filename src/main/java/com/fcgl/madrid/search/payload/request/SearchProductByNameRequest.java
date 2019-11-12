package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotEmpty;

public class SearchProductByNameRequest {

    @NotEmpty
    private String name;
    private Long userId;

    public SearchProductByNameRequest(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
