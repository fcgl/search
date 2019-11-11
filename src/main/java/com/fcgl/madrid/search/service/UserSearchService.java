package com.fcgl.madrid.search.service;

import com.fcgl.madrid.search.payload.request.UserId;
import com.fcgl.madrid.search.dataModel.UserSearch;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.payload.response.SearchHistoryResponse;
import com.fcgl.madrid.search.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserSearchService {
    //TODO: Add necessary functions

    private UserSearchRepository userSearchRepo;

    @Autowired
    public UserSearchService(UserSearchRepository userSearchRepo) {
        this.userSearchRepo = userSearchRepo;
    }

    public ResponseEntity<Response<String>> addQueryToTable(UserSearchRequest request) {
        Long userId = request.getUserId();
        String query = request.getQuery();
        Date date = new Date();

        UserSearch model = new UserSearch(new UserId(userId), query, date);
        UserSearch resp = userSearchRepo.save(model);

        InternalStatus status;
        HttpStatus respStatus;
        String responseMessage;

        if (resp != null) {
            status = InternalStatus.OK;
            respStatus = HttpStatus.OK;
            responseMessage = "Added query successfully";
        } else {
            status = InternalStatus.NOT_FOUND;
            respStatus = HttpStatus.NOT_ACCEPTABLE;
            responseMessage = "Adding query failed";
        }

        Response response = new Response<>(status, responseMessage);
        return new ResponseEntity<Response<String>>(response, respStatus);

    }

    public ResponseEntity<Response<SearchHistoryResponse>> searchByUserId(UserId userId) {
        List<UserSearch> searchHistory = userSearchRepo.findByUserId(userId);
        Response response = new Response<SearchHistoryResponse>(InternalStatus.OK, new SearchHistoryResponse(searchHistory));
        return new ResponseEntity<Response<SearchHistoryResponse>>(response, HttpStatus.OK);
    }
}
