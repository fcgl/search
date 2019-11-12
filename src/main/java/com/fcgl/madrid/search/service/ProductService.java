package com.fcgl.madrid.search.service;

import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.request.SearchProductByNameRequest;
import com.fcgl.madrid.search.payload.response.ProductSearchResponse;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.repository.ProductRepository;
import com.fcgl.madrid.search.repository.elasticsearch.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductSearchRepository productSearchRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductSearchRepository productSearchRepository) {
        this.productRepository = productRepository;
        this.productSearchRepository = productSearchRepository;
    }

    public ResponseEntity<Response<ProductSearchResponse>> searchByName(SearchProductByNameRequest request) {
        List<ProductSearch> productSearches = this.productSearchRepository.findByName(request.getName());
        Response<ProductSearchResponse> response = new Response<ProductSearchResponse>(InternalStatus.OK, new ProductSearchResponse(productSearches));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}