    package com.poly.website_norulesshop.dto;

    import lombok.Data;

    @Data
    public class EditProductDTO {
        String productName;
        Double productPrice;
        Double productDiscount;
        Integer brandId;
        Integer directoryLv1Id;
        String productDescription;
    }
