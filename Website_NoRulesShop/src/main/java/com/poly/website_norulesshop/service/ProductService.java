package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product product);

    Page<Product> productPaginate(int page, int pageSize);

    Page<Product> productPaginateWithFilter(Integer brandId, Integer directoryLv1Id, String keyword, String priceSort, int page, int pageSize);

    Product getProductById(Integer id);

    List<Product> getProductByBrandId(Integer brandId);

    List<Product> getAllProducts();

    Integer getTotalQuantity(Integer id);

    void deleteProduct(Integer id);

    Product findProductWithImagesById(Integer id);

    List<Product> isHidden();

    List<Product> isActive();

    List<Product> isSoldOut();
}
