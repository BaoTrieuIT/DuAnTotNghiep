package com.poly.website_norulesshop.utils;

import lombok.Data;

@Data
public class FilterCriteria {
    private Integer brandId;
    private Integer directoryLv1Id;
    private String priceSort;

    public void clear() {
        this.brandId = null;
        this.directoryLv1Id = null;
        this.priceSort = null;
    }
}
