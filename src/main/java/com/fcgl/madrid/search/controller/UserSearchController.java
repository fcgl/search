package com.fcgl.madrid.search.controller;

import com.fcgl.madrid.search.dataModel.UserId;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.Response;
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
     *
     * TODO: Based on what we find out on elastic search. We might have to make an api request to elastic search from here as well.
     */
    @PostMapping(path = "/query")
    public ResponseEntity<Response<String>> addUserSearchQuery(@Valid @RequestBody UserSearchRequest request) {
        return userSearchService.addQueryToTable(request);
    }

    @GetMapping(path = "/query") //TODO returns a 500 not sure why
    public ResponseEntity<Response<String>> getQueriesForUser(@Valid @PathVariable Long userId) {
        return userSearchService.searchByUserId(new UserId(userId));
    }
}