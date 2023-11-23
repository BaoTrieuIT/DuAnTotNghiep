package com.poly.website_norulesshop.utils;

import lombok.Data;

@Data
public class FilterCategoryCriteria {
    private Integer productId;
    private Integer categoryLv1DetailId;
    private Integer categoryLv2DetailId;


    public void clear() {
        this.productId = null;
        this.categoryLv1DetailId = null;
        this.categoryLv2DetailId = null;
    }
}
