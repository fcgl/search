package com.fcgl.madrid.search.controller;
import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import com.fcgl.madrid.search.payload.request.SearchProductByNameRequest;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.ProductSearchResponse;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.service.ProductService;
import com.fcgl.madrid.search.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/search/v1")
public class SearchController {

    private ProductService productService;
    private UserSearchService userSearchService;

    @Autowired
    public SearchController(ProductService productService, UserSearchService userSearchService) {
        this.productService = productService;
        this.userSearchService = userSearchService;
    }

    @GetMapping(value = "/product/name")
    public ResponseEntity<Response<ProductSearchResponse>> searchProductByName(@Valid SearchProductByNameRequest request) {
        if (request.getUserId() != null) {
            userSearchService.addQueryToTable(new UserSearchRequest(request.getUserId(), request.getName()));
        }
        return productService.searchByName(request);
    }

}
