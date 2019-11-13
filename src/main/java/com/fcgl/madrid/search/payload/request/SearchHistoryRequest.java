package com.fcgl.madrid.search.payload.request;

import javax.validation.constraints.NotNull;

public class SearchHistoryRequest {

    @NotNull
    private Long userId;
    private Integer pageSize;
    private Integer page;

    public SearchHistoryRequest(@NotNull Long userId, Integer pageSize, Integer pageNum) {
        this.userId = userId;
        this.pageSize = pageSize;
        this.page = pageNum;

        // handle default page size value
        if (this.pageSize == null) {
            this.pageSize = 10;
        }
        // handle default page value
        if (page == null) {
            this.page = 0;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPage() {
        return page;
    }
}
