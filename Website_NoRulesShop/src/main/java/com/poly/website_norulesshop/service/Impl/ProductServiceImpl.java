package com.poly.website_norulesshop.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveProduct(Product product) {
        productRepository.save(product);
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
        productName = "%"+ productName+ "%";
        return productRepository.findProductByProductNameLikeAndIsRemoved(productName, false);
    }

    @Override
    public List<Product> SearchProductHiddenByName(String productName) {
        productName = "%"+ productName+ "%";
        return productRepository.findProductByProductNameLikeAndIsRemoved(productName, true);
    }

    @Override
    public List<Product> SearchProductSoldoutByName(String productName) {
        productName = "%"+ productName+ "%";
        List<Product> listProductIsSoldOutAndNameBy =  productRepository.findProductByProductNameLike(productName);
        List<Product> productListToReturn = new ArrayList<>();
        for (Product product: listProductIsSoldOutAndNameBy) {
            if(product.getTotalQuantity() == 0){
                productListToReturn.add(product);
            }
        }
        return productListToReturn;
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
        List<Product> listProduct  = productRepository.findAll();
        List<Product> listProductIsSoldOut = new ArrayList<>();
        for (Product product: listProduct) {
            if(product.getTotalQuantity() == 0){
                listProductIsSoldOut.add(product);
            }
        }
         return  listProductIsSoldOut;
    }
}
