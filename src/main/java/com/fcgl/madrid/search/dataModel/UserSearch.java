package com.fcgl.madrid.search.dataModel;
import com.fcgl.madrid.search.payload.request.UserId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class UserSearch {

    //TODO: Change UserId and all its use cases with UserSearch to Long
    @Id
    public String id;
    public UserId userId;
    public String query;
    public Date addedOn;

    public UserSearch(UserId userId, String query, Date addedOn) {
        this.userId = userId;
        this.query = query;
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "UserSearch{" +

                ", userId=" + userId.getUserId() +
                ", query='" + query + '\'' +
                ", addedOn=" + addedOn +
                '}';
    }
}
