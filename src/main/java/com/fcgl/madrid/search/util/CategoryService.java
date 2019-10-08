package com.fcgl.madrid.search.util;

import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.repository.CategoryRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
