package com.poly.website_norulesshop.dto;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class EditProductDTO {
    Product product;
    List<CategoryQuantity> categoryQuantities;
}