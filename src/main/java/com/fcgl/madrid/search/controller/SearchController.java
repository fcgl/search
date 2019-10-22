package com.fcgl.madrid.search.controller;
import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import com.fcgl.madrid.search.payload.request.SearchProductByNameRequest;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search/v1")
public class SearchController {

    ProductService productService;

    @Autowired
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/name")
    public ResponseEntity<Response<List<ProductSearch>>> searchProductByName(SearchProductByNameRequest request) {
        return productService.searchByName(request);
    }

}
