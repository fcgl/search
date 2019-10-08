package com.fcgl.madrid.search.controller;
import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.util.CategoryService;
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
}


