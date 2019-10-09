package com.fcgl.madrid.search.controller;
import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.dataModel.Product;
import com.fcgl.madrid.search.payload.request.CategorySearchRequest;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/search/category/v1")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setServices(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/allCategories")
    public ResponseEntity<Response<List<Category>>> getAllCategories() {
        return categoryService.getAllCategories();
    }


    /**
     * Searches based on category
     *  TODO: Return a paginated list of products based on the categoryId sent in the request...
     *        Note: Should return a ResponseEntity<Response<List<?>> The ? could be another object if necessary
     *        OR: List<?> could also be a Object with a List<?> as one of it's fields
     *        RESPONSE: Product Name, Category Name(s), Retail Price, Merchant Price, Merchant Location, Product Image,
     *            Along with IDs for whatever Ids that might be helpful (Product/MerchantProduct Id)
     *
     * Extra TODO: We would want to return a result sorted based on distance from the user. Have not looked into how
     *              geolocation works yet. But would be an extra once we figure that out
     *
     */
    @GetMapping(path="/search")
    public ResponseEntity<Response<List<Product>>> GetCategoryProducts(@Valid CategorySearchRequest request) {
        return null;
    }
}
