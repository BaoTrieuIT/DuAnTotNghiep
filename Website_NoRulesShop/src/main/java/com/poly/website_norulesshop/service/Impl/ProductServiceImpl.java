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
    public Page<Product> productPaginateWithFilter(Integer brandId, Integer directoryLv1Id, String keyword, String priceSort, int page, int pageSize) {
        Pageable pageable;
        if (priceSort != null && priceSort.equalsIgnoreCase("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by("priceNew"));
        } else if (priceSort != null && priceSort.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by("priceNew").descending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.unsorted());
        }
        Specification<Product> spec = Specification.where(null);
        if (brandId != null) {
            spec = ProductSpecification.findbyBrandId(brandId);
        }
        if (directoryLv1Id != null) {
            spec = ProductSpecification.findbyDirectoryLV1Id(directoryLv1Id);
        }
        if (keyword != null && !keyword.isEmpty()) {
            spec = ProductSpecification.findByProductname(keyword);
        }
        return productRepository.findAll(spec, pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByBrandId(Integer brandId) {
        return productRepository.findByBrandId(brandId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Integer getTotalQuantity(Integer id) {
        return productRepository.getTotalById(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
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
