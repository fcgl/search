package com.fcgl.madrid.search.dataModel;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Category {

    @Id
    public int id;
    public String categoryName;
    public String description;
    public Date addedOn;
    public Date lastUpdated;

    public Category(int id, String categoryName, String description, Date addedOn, Date lastUpdated) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.addedOn = addedOn;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", added_on=" + addedOn +
                ", last_updated=" + lastUpdated +
                '}';
    }
}
