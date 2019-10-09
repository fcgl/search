package com.fcgl.madrid.search.controller;
import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.dataModel.Product;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.request.CategorySearchRequest;
import com.fcgl.madrid.search.payload.request.ProductBody;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.service.CategoryService;
import com.fcgl.madrid.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/search/product/v1")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setServices(ProductService productService) {
        this.productService = productService;
    }

    /**
     * TODO: Update the popularityIndex
     * Parses the List<ProductBody> and updates every Product based on the id and the new popularityIndex
     * Note: We will be securing our API through JWT tokens which include encrypted Roles. So do need to worry
     * about security in this endpoint as it will be taken care of
     */
    @PostMapping(path = "/productPopularityIndex")
    public ResponseEntity<Response<InternalStatus>> updatePopularityIndex(@RequestBody List<ProductBody> request) {
        return null;
    }
}
