package com.fcgl.madrid.search.controller;

import com.fcgl.madrid.search.payload.request.UserId;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.payload.response.SearchHistoryResponse;
import com.fcgl.madrid.search.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/search/userSearch/v1")
public class UserSearchController {
    private UserSearchService userSearchService;

    @Autowired
    public void setServices(UserSearchService categoryService) {
        this.userSearchService = categoryService;
    }

    /**
     * We want to keep track of the searches a user has made
     * This endpoint simply adds an entry to the UserSearch database table based on the search a user has made
     * <p>
     * TODO: Based on what we find out on elastic search. We might have to make an api request to elastic search from here as well.
     */
    @PostMapping(path = "/query")
    public ResponseEntity<Response<String>> addUserSearchQuery(@Valid @RequestBody UserSearchRequest request) {
        return userSearchService.addQueryToTable(request);
    }

    /**
     * This endpoint returns a paginated list of queries that a user has made.
     *
     * @param id       specify user id to be queried
     * @param pageSize Optional parameter: specify number of queries per page
     * @param page     Optional parameter: specify page number of results
     * @return list of results
     */
    @GetMapping(path = "query") //expect page index starting from 1, so subtract one for querying purposes
    public ResponseEntity<Response<SearchHistoryResponse>> getRecentQueriesForUser(@Valid UserId id,
                                                                                   @RequestParam(required = false) Integer pageSize,
                                                                                   @RequestParam(required = false) Integer page) {
        // handle default page size value
        if (pageSize == null) {
            pageSize = 10;
        }
        // handle default page value
        if (page == null) {
            page = 0;
        } else {
            page = page - 1;
        }
        return userSearchService.searchByUserIdRecent(id, pageSize, page);
    }
}