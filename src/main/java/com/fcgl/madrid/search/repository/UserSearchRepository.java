package com.fcgl.madrid.search.repository;

import com.fcgl.madrid.search.payload.request.UserId;
import com.fcgl.madrid.search.dataModel.UserSearch;
import org.apache.catalina.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserSearchRepository extends MongoRepository<UserSearch, String> {

    public List<UserSearch> findByUserId(UserId userId);

    public List<UserSearch> findByUserIdOrderByAddedOnDesc(UserId userId, Pageable pageable);

    public List<UserSearch> findByQuery(String query);

    public int countByUserId(UserId userId);

}
