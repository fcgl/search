package com.fcgl.madrid.search.dataModel;
import java.util.Date;

public class UserSearch {

    public Long userId;
    public String query;
    public Date addedOn;

    public UserSearch(Long userId, String query, Date addedOn) {
        this.userId = userId;
        this.query = query;
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "UserSearch{" +

                ", userId=" + userId +
                ", query='" + query + '\'' +
                ", addedOn=" + addedOn +
                '}';
    }
}
