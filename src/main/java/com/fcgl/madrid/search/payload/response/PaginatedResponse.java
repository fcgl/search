package com.fcgl.madrid.search.payload.response;

/**
 * This class serves as a wrapper for returning a Paginated responses
 *
 * @param <T> Response
 */
public class PaginatedResponse<T> {

    private T content;

    private int pageNumber;
    private int pageSize;
    private int totalRecords;

    public PaginatedResponse(T content, int pageSize, int pageNumber, int totalRecords) {
        this.content = content;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalRecords = totalRecords;
    }

    public T getContent() {
        return content;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalRecords() {
        return totalRecords;
    }
}
