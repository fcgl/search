package com.fcgl.madrid.search.service;

import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Response<List<Category>>> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        Response response = new Response<>(InternalStatus.OK, allCategories);
        return new ResponseEntity<Response<List<Category>>>(response, HttpStatus.OK);
    }
}
