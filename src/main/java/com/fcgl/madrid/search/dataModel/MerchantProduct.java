package com.fcgl.madrid.search.dataModel;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class MerchantProduct {

    @Id
    public int id;
    public int merchantId;
    public int productID;
    public Map<String, Object> product;
    public Map<String, Object> price;

    public MerchantProduct(int id, int merchantId, int productID, Map<String, Object> product, Map<String, Object> price) {
        this.id = id;
        this.merchantId = merchantId;
        this.productID = productID;
        this.product = product;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MerchantProduct{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", productID=" + productID +
                ", product=" + product +
                ", price=" + price +
                '}';
    }
}

