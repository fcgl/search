package com.fcgl.madrid.search.repository;

import com.fcgl.madrid.search.dataModel.MerchantProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface MerchantProductRepository extends MongoRepository<MerchantProduct, String> {

    public MerchantProduct findById(int id);

    public MerchantProduct findByMerchantId(int merchantId);

    public MerchantProduct findByProduct(Map<String, Object> product);

    public MerchantProduct findByPrice(Map<String, Object> price);

}
