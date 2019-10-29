package com.fcgl.madrid.search.dataModel;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Merchant {

    @Id
    public int id;
    public String name;
    public String location;
    public Date addedOn;
    public Date lastUpdated;
    public List<Map<String, Object>> merchantHours;

    public Merchant(int id, String name, String location, Date addedOn, Date lastUpdated, List<Map<String, Object>> merchantHours) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.addedOn = addedOn;
        this.lastUpdated = lastUpdated;
        this.merchantHours = merchantHours;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", addedOn=" + addedOn +
                ", lastUpdated=" + lastUpdated +
                ", merchantHours=" + merchantHours +
                '}';
    }
}