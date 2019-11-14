package com.fcgl.madrid.search.service;

import com.fcgl.madrid.search.payload.request.SearchHistoryRequest;
import com.fcgl.madrid.search.payload.request.UserId;
import com.fcgl.madrid.search.dataModel.UserSearch;
import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.request.UserSearchRequest;
import com.fcgl.madrid.search.payload.response.PaginatedResponse;
import com.fcgl.madrid.search.payload.response.Response;
import com.fcgl.madrid.search.payload.response.SearchHistoryResponse;
import com.fcgl.madrid.search.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserSearchService {

    private UserSearchRepository userSearchRepo;

    @Autowired
    public UserSearchService(UserSearchRepository userSearchRepo) {
        this.userSearchRepo = userSearchRepo;
    }

    /**
     * This method adds the given query to the UserSearch table.
     *
     * @param request UserSearchRequest
     * @return Status
     */
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

    /**
     * This method returns queries in a paginated format made by a user.
     *
     * @param searchHistoryRequest Request object that contains the user id, page size and page
     * @return response
     */
    public ResponseEntity<Response<SearchHistoryResponse>> searchByUserIdRecent(SearchHistoryRequest searchHistoryRequest) {
        // Paginate List
        UserId id = new UserId(searchHistoryRequest.getUserId());
        int pageSize = searchHistoryRequest.getPageSize();
        int page = searchHistoryRequest.getPage();

        Pageable pageableRequest = PageRequest.of(page, pageSize);
        List<UserSearch> searchHistory = userSearchRepo.findByUserIdOrderByAddedOnDesc(id, pageableRequest);
        // Get total number of records
        int records = userSearchRepo.countByUserId(id);
        // Format Response
        PaginatedResponse paginatedResponse = new PaginatedResponse<>(new SearchHistoryResponse(searchHistory), pageSize, page, records);
        Response response = new Response<>(InternalStatus.OK, paginatedResponse);
        return new ResponseEntity<Response<SearchHistoryResponse>>(response, HttpStatus.OK);
    }
}
