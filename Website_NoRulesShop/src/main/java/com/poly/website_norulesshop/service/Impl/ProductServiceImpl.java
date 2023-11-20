package com.poly.website_norulesshop.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.website_norulesshop.Repository.Specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.ProductRepository;
import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> productPaginate(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> productPaginateWithFilter(Integer brandId, Integer directoryId, Integer genderId, Integer categoryLV1DetailId, Integer categoryLV2DetailId, String priceSort, int page, int pageSize) {
        Pageable pageable;
        if (priceSort != null && priceSort.equalsIgnoreCase("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by("priceMin"));
        } else if (priceSort != null && priceSort.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by("priceMin").descending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.unsorted());
        }
        Specification<Product> spec = Specification.where(null);
        if (brandId != null) {
            spec = ProductSpecification.findbyBrandId(brandId);
        }
        if (directoryId != null) {
            spec = ProductSpecification.findbyDirectoryId(directoryId);
        }
        if (genderId != null) {
            spec = ProductSpecification.findbyGenderId(genderId);
        }
        if (categoryLV1DetailId != null) {
            spec = ProductSpecification.findbyCategoryLV1Detail(categoryLV1DetailId);
        }
        if (categoryLV2DetailId != null) {
            spec = ProductSpecification.findbyCategoryLV2Detail(categoryLV2DetailId);
        }
        return productRepository.findAll(spec, pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> SearchProductActiveByName(String productName) {
        productName = "%" + productName + "%";
        return productRepository.findProductByProductNameLikeAndIsRemoved(productName, false);
    }

    @Override
    public List<Product> SearchProductHiddenByName(String productName) {
        productName = "%" + productName + "%";
        return productRepository.findProductByProductNameLikeAndIsRemoved(productName, true);
    }

    @Override
    public List<Product> SearchProductSoldoutByName(String productName) {
        productName = "%" + productName + "%";
        List<Product> listProductIsSoldOutAndNameBy = productRepository.findProductByProductNameLike(productName);
        List<Product> productListToReturn = new ArrayList<>();
        for (Product product : listProductIsSoldOutAndNameBy) {
            if (product.getTotalQuantity() == 0) {
                productListToReturn.add(product);
            }
        }
        return productListToReturn;
    }

    @Override
    public Product findProductWithImagesById(Integer id) {
        return productRepository.findProductWithImagesById(id);
    }


    @Override
    public List<Product> isHidden() {
        return productRepository.findProductByIsRemoved(true);
    }

    @Override
    public List<Product> isActive() {
        return productRepository.findProductByIsRemoved(false);
    }

    @Override
    public List<Product> isSoldOut() {
        List<Product> listProduct = productRepository.findAll();
        List<Product> listProductIsSoldOut = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getTotalQuantity() == 0) {
                listProductIsSoldOut.add(product);
            }
        }
        return listProductIsSoldOut;
    }
}
