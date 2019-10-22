package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotEmpty;

public class SearchProductByNameRequest {

    @NotEmpty
    private String name;

    public SearchProductByNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
