package com.poly.website_norulesshop.dto;

import com.poly.website_norulesshop.model.CategoryLevel1;
import com.poly.website_norulesshop.model.CategoryLevel1Detail;
import com.poly.website_norulesshop.model.CategoryLevel2;
import com.poly.website_norulesshop.model.CategoryLevel2Detail;
import lombok.Data;

@Data
public class CategoryQuantityDTO {
    CategoryLevel1Detail categoryLevel1Detail ;
    CategoryLevel2Detail categoryLevel2Detail;
    Integer quantity;
}
