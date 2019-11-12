package com.fcgl.madrid.search.payload.response;

import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import java.util.List;

public class ProductSearchResponse {

    private List<ProductSearch> products;

    public ProductSearchResponse(List<ProductSearch> products) {
        this.products = products;
    }

    public List<ProductSearch> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSearch> products) {
        this.products = products;
    }
}
