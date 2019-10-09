package com.fcgl.madrid.search.controller;

import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.dataModel.Product;
import com.fcgl.madrid.search.payload.request.CategorySearchRequest;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.service.CategoryService;
import com.fcgl.madrid.search.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping(path = "/query")
    public ResponseEntity<Response> addUserSearchQuery(@Valid UserSearchRequest request) {
        //Call a function is userSearchService
        return null;
    }
}