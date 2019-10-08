package com.fcgl.madrid.search.dataModel;

import org.springframework.data.annotation.Id;

public class MerchantCategory {

    @Id
    public int id;
    public int merchantId;
    public int productId;
    public int categoryId;
    public int priceLevelId;

    public MerchantCategory(int id, int merchantId, int productId, int categoryId, int priceLevelId) {
        this.id = id;
        this.merchantId = merchantId;
        this.productId = productId;
        this.categoryId = categoryId;
        this.priceLevelId = priceLevelId;
    }

    @Override
    public String toString() {
        return "MerchantCategory{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", priceLevelId=" + priceLevelId +
                '}';
    }
}


