package com.fcgl.madrid.search.payload.request;
import javax.validation.constraints.NotNull;

public class ProductBody {
    @NotNull
    private Integer productId;
    @NotNull
    private Float popularityIndex;

    public ProductBody(Integer productId, Float popularityIndex) {
        this.productId = productId;
        this.popularityIndex = popularityIndex;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(Float popularityIndex) {
        this.popularityIndex = popularityIndex;
    }
}
