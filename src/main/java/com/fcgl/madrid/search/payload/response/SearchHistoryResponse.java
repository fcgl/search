package com.fcgl.madrid.search.payload.response;
import com.fcgl.madrid.search.dataModel.UserSearch;

import java.util.List;

public class SearchHistoryResponse {

    private List<UserSearch> searchHistory;

    public SearchHistoryResponse(List<UserSearch> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public List<UserSearch> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(List<UserSearch> searchHistory) {
        this.searchHistory = searchHistory;
    }
}
