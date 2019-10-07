package com.fcgl.madrid.search.repository;

import java.util.Date;
import java.util.List;

import com.fcgl.madrid.search.dataModel.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    public Category findById(int id);
    public Category findByCategoryName(String categoryName);
    public Category findByDescription(String description);
    public Category findByAddedOn(Date addedOn);
    public Category findByLastUpdated(Date lastUpdated);

}
