package com.fcgl.madrid.search.repository;

import java.util.List;

import com.fcgl.madrid.search.dataModel.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findByName(String name);
    public List<Product> findByBarcode(int barcode);

}
