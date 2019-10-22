package com.fcgl.madrid.search.dataModel.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "product", type = "product")
public class ProductSearch {

    @Id
    private Long id;
    public String name;
    public double retail_price;
    public Integer barcode;
    public String default_image;
    public List<String> categories;
    public double popularityIndex;
    private final static String INDEX_NAME = "product";
    private final static String TYPE_NAME = "product";

    public ProductSearch() {

    }

    public ProductSearch(Long id, String name, double retail_price, Integer barcode, String default_image,
                         List<String> categories, double popularityIndex) {
        this.id = id;
        this.name = name;
        this.retail_price = retail_price;
        this.barcode = barcode;
        this.default_image = default_image;
        this.categories = categories;
        this.popularityIndex = popularityIndex;
    }

    public ProductSearch(Long id, String name, double retail_price, Integer barcode, String default_image,
                         String category, double popularityIndex) {
        this.id = id;
        this.name = name;
        this.retail_price = retail_price;
        this.barcode = barcode;
        this.default_image = default_image;
        this.categories = new ArrayList<>();
        this.categories.add(category);
        this.popularityIndex = popularityIndex;
    }

    public void setRetail_price(Float retail_price) {
        this.retail_price = retail_price;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public String getDefault_image() {
        return default_image;
    }

    public void setDefault_image(String default_image) {
        this.default_image = default_image;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public double getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(double popularityIndex) {
        this.popularityIndex = popularityIndex;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public static String getIndexName() {
        return INDEX_NAME;
    }

    public static String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", retail_price='" + retail_price + '\'' +
                ", barcode='" + barcode + '\'' +
                ", barcode='" + barcode + '\'' +
                ", categories='" + categories + '\'' +
                ", default_image='" + default_image + '\'' +
                ", popularityIndex='" + popularityIndex + '\'' +
                '}';
    }

}

