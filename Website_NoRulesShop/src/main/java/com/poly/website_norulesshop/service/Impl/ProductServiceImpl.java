package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
//
//    private final ProductRepository productRepository;
//
//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public void saveProduct(Product product) {
//        productRepository.save(product);
//    }
//
//    @Override
//    public Product getProductById(Integer id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Product> SearchProductActiveByName(String productName) {
//        productName = "%" + productName + "%";
//        return productRepository.findByProductNameLikeAndAndIsRemoved(productName, false);
//    }
//
//    @Override
//    public List<Product> SearchProductHiddenByName(String productName) {
//        productName = "%" + productName + "%";
//        return productRepository.findByProductNameLikeAndAndIsRemoved(productName, true);
//    }
//
//    @Override
//    public List<Product> SearchProductSoldoutByName(String productName) {
//        List<Product> listProduct = productRepository.findAll();
//        List<Product> listProductIsSoldOut = new ArrayList<>();
//        for (Product product : listProduct) {
//            Integer checkSoldOut = 0;
//            for (CategoryQuantity categoryQuantity : product.getCategoryQuantityList()) {
//                checkSoldOut += categoryQuantity.getQuantity();
//            }
//            if (checkSoldOut == 0) {
//                listProductIsSoldOut.add(product);
//            }
//        }
//        List<Product> listProductIsSoldOutAndNameBy = new ArrayList<>();
//        for (Product product : listProductIsSoldOut) {
//            if (product.getProduct_name().contains(productName)) {
//                listProductIsSoldOutAndNameBy.add(product);
//            }
//        }
//        return listProductIsSoldOutAndNameBy;
//    }
//
//
//    @Override
//    public List<Product> isHidden() {
//        return productRepository.findProductByIsRemoved(true);
//    }
//
//    @Override
//    public List<Product> isActive() {
//        return productRepository.findProductByIsRemoved(false);
//    }
//
//    @Override
//    public List<Product> isSoldOut() {
//        List<Product> listProduct = productRepository.findAll();
//        List<Product> listProductIsSoldOut = new ArrayList<>();
//        for (Product product : listProduct) {
//            Integer checkSoldOut = 0;
//            for (CategoryQuantity categoryQuantity : product.getCategoryQuantityList()) {
//                checkSoldOut += categoryQuantity.getQuantity();
//            }
//            if (checkSoldOut == 0) {
//                listProductIsSoldOut.add(product);
//            }
//        }
//        return listProductIsSoldOut;
//    }
}
