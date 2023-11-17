package com.poly.website_norulesshop.utils;

import lombok.Data;

@Data
public class FilterCriteria {
    private Integer brandId;
    private Integer directoryId;
    private Integer genderId;
    private Integer categoryLV1DetailId;
    private Integer categoryLV2DetailId;
    private String priceSort;

    public void clear() {
        this.brandId = null;
        this.directoryId = null;
        this.genderId = null;
        this.categoryLV1DetailId = null;
        this.categoryLV2DetailId = null;
        this.priceSort = null;
    }
}
