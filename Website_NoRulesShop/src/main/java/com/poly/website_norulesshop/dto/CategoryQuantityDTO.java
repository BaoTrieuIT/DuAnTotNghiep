package com.poly.website_norulesshop.dto;

import com.poly.website_norulesshop.entity.CategoryLevel1Detail;
import com.poly.website_norulesshop.entity.CategoryLevel2Detail;
import lombok.Data;

@Data
public class CategoryQuantityDTO {
    CategoryLevel1Detail categoryLevel1Detail;
    CategoryLevel2Detail categoryLevel2Detail;
    Integer quantity;
}
