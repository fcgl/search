package com.fcgl.madrid.search.repository.elasticsearch;

import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepository extends ElasticsearchCrudRepository<ProductSearch, Long> {
    List<ProductSearch> findByName(String name);
}

