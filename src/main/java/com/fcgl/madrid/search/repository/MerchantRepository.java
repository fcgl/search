package com.fcgl.madrid.search.repository;

import com.fcgl.madrid.search.dataModel.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface MerchantRepository extends MongoRepository<Merchant, String> {

    public Merchant findById(int id);
    public Merchant findByName(String name);
    public Merchant findByLocation(String location);
    public Merchant findByAddedOn(Date addedOn);
    public Merchant findByLastUpdated(Date lastUpdated);

}
