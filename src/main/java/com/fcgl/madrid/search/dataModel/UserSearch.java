package com.fcgl.madrid.search.dataModel;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class UserSearch {

    @Id
    public int id;
    public Integer userId;
    public String query;
    public Date addedOn;

    public UserSearch(int id, String categoryName, String description, Date addedOn, Date lastUpdated) {
        this.id = id;
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                "id=" + id +
                ", userId=" + userId +
                ", query='" + query + '\'' +
                ", addedOn=" + addedOn +
                '}';
    }
}
