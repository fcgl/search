package com.fcgl.madrid.search.payload.request;

import javax.validation.constraints.NotNull;

public class CategorySearchRequest {
    @NotNull
    private Integer categoryId;
    //Page and Size are for pagination reasons
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;

    //We will only be supporting Madrid at the beginning, but we should still
    //work based on the cityId. Currently none of our database models take cityId into account
    //Will probably have to be added to one or all of the Merchant Data Models
    private Integer cityid;

    CategorySearchRequest(Integer categoryId, Integer cityid, Integer page, Integer size) {
        this.categoryId = categoryId;
        this.cityid = cityid;
        this.page = page;
        this.size = size;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }
}
