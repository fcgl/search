package com.fcgl.madrid.search.repository;

import com.fcgl.madrid.search.payload.request.UserId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserIdRepository extends MongoRepository<UserId, String> {

    public UserId findByUserId(UserId userId);

}
