package com.fcgl.madrid.search.repository;

import com.fcgl.madrid.search.dataModel.MerchantCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantCategoryRepository extends MongoRepository<MerchantCategory, String> {

    public MerchantCategory findById();

    public MerchantCategory findByMerchantId();

    public MerchantCategory findByProductId();

    public MerchantCategory findByCategoryId();

    public MerchantCategory findByPriceLevelId();

}
