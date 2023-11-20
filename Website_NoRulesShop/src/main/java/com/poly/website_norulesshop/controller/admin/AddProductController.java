package com.poly.website_norulesshop.controller.admin;


import com.poly.website_norulesshop.dto.CategoryLv1DetailDTO;
import com.poly.website_norulesshop.dto.CategoryLv2DetailDTO;
import com.poly.website_norulesshop.dto.CategoryQuantityDTO;
import com.poly.website_norulesshop.model.*;
import com.poly.website_norulesshop.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("api/product")
public class AddProductController {

    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    HttpSession httpSession;



    @Autowired
    ProductInformationTypeService productInformationTypeService;
    @Autowired
    InformationTypeService informationTypeService;

    @Autowired
    CategoryLevel2Service  categoryLevel2Service;
    @Autowired
    CategoryLevel1Service categoryLevel1Service;



    @Autowired
    CategoryLevel1DetailService categoryLevel1DetailService;
    @Autowired
    CategoryLevel2DetailService categoryLevel2DetailService;
    CategoryLevel1 addCategoryLevel1= new CategoryLevel1();
    CategoryLevel2 addCategoryLevel2 = new CategoryLevel2();
    CategoryLevel2Detail addCategoryLevel2Detail =  new CategoryLevel2Detail();
    CategoryLevel1Detail addCategoryLevel1Detail = new CategoryLevel1Detail();


    private CategoryLevel1 currentCategoryLevel1;
    private CategoryLevel2 currentCategoryLevel2;

    private Product currentProduct;

    @Autowired
    CategoryQuantityService categoryQuantityService;

    @PostMapping("addProduct")
    public Product AddProduct(
            @RequestParam String productName,
             @RequestParam String productBrandId,
             @RequestParam String productDirectoryId,
             @RequestParam String productDescription,
            @RequestParam Double productPrice,
            @RequestParam Double productDiscount
    ){
        try{
            Product product = new Product();
            product.setProductName(productName);
            Brand brand = brandService.getBrandById(Integer.parseInt(productBrandId));
            product.setBrand(brand);
            DirectoryLv1 directoryLv1 = directoryLv1Service.getDirectoryLv1ById(Long.parseLong(productDirectoryId));
            product.setDirectoryLv1(directoryLv1);
            product.setProductDescription(productDescription);
            product.setCreateDate(new Date());
            product.setPriceOld(productPrice);
            product.setDiscount(productDiscount);
            if(productDiscount > 0 && productDiscount <= 1){
                product.setPriceNew(productPrice * productDiscount );
            }else if(productDiscount > 1 && productDiscount  <= 100 ){
                product.setPriceNew(productPrice * productDiscount / 100 );
            }else if(productDiscount > 100){
                product.setPriceNew(productPrice - productDiscount);
            }else{
                System.out.println("error");
            }
            currentProduct = productService.saveProduct(product);
            return currentProduct;
        }catch (Exception e){
            return null;
        }
    }


    @PostMapping("addProductImages")
    public List<ProductImage> addProductImages(@RequestPart("files") List<MultipartFile> files) throws IOException {
//        tạo
        System.out.println("here");
        Map<String, MultipartFile> fileMap =  new HashMap<>();
//        lấy product đã lưu vào session từ lúc thêm sản phẩm
//        Tạo File Name và gắn vào hashmap để có thể lưu file name không bị trùng
        for (MultipartFile file: files) {
            String originalFilename = file.getOriginalFilename();
            String extension = "";
            int lastIndex = originalFilename.lastIndexOf('.');
            if (lastIndex >= 0) {
                extension = System.currentTimeMillis() + String.valueOf(files.lastIndexOf(file)) +  originalFilename.substring(lastIndex);
            }
            System.out.println(extension);
            fileMap.put(extension,file);
        }
//       upload ảnh
        fileUploadService.saveFiles(fileMap);
//       thêm dữ liệu vào productImage
        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            String key = entry.getKey();

            ProductImage productImage= new ProductImage();
            productImage.setImageUrl(key);
            System.out.println(key);
            productImage.setProduct(currentProduct);
            productImageService.saveProductImage(productImage);
        }
        return null;
    }


    @PostMapping("addProductInfo")
    public  ProductInformationType addProductInfomationType(
            @RequestParam String value,
            @RequestParam String infomationTypeId
    ){

        ProductInformationType productInformationType = new ProductInformationType();
//        get
        InformationType informationType = informationTypeService.getInformationTypeById(Long.parseLong(infomationTypeId));
//        set
        productInformationType.setInformationType(informationType);
        productInformationType.setProduct(currentProduct);
        productInformationType.setInformationTypeValue(value);
//        save
        productInformationTypeService.saveProductInformationType(productInformationType);
        return productInformationType;
    }


    @PostMapping("addCategoryLv1")
    public  CategoryLevel1 addCategoryLv1(
        @RequestParam("categoryName") String categoryLv1Name
    ){
        CategoryLevel1 categoryLevel1 = new CategoryLevel1();
        categoryLevel1.setCategoryLevel1Name(categoryLv1Name);
        currentCategoryLevel1 =  categoryLevel1Service.saveCategoryLevel1(categoryLevel1);
        return currentCategoryLevel1;
    }

    @PostMapping("addCategoryLv2")
    public CategoryLevel2 addCategoryLv2(
            @RequestParam("categoryName") String categoryLv2Name
    ){
        CategoryLevel2 categoryLevel2 = new CategoryLevel2();
        categoryLevel2.setCategoryLevel2Name(categoryLv2Name);
        currentCategoryLevel2 =  categoryLevel2Service.saveCategoryLevel2(categoryLevel2);
        return currentCategoryLevel2;
    }

    @PostMapping("addCategoryLv1_Detail")
    public List<CategoryLevel1Detail> addCategoryLv1Detail(
            @RequestBody CategoryLv1DetailDTO categoryLv1DetailDTO
    ){
        List<CategoryLevel1Detail> categoryLevel1Details =  new ArrayList<>();
        for (String CategoryLv1DetailName : categoryLv1DetailDTO.getCategoryLv1Details()) {
            CategoryLevel1Detail categoryLevel1Detail = new CategoryLevel1Detail();
            categoryLevel1Detail.setCategoryLevel1DetailName(CategoryLv1DetailName);
            categoryLevel1Detail.setCategoryLevel1(currentCategoryLevel1);
            categoryLevel1Details.add( categoryLevel1DetailService.saveCategoryLevel1Detail(categoryLevel1Detail));
        }
        return categoryLevel1Details ;
    }


    @PostMapping("addCategoryLv2_Detail")
    public List<CategoryLevel2Detail> addCategoryLv2Detail(
            @RequestBody CategoryLv2DetailDTO categoryLv2DetailDTO
    ){
        List<CategoryLevel2Detail> categoryLevel2Details =  new ArrayList<>();
        for (String item : categoryLv2DetailDTO.getCategoryLv2Details()) {
            CategoryLevel2Detail categoryLevel2Detail = new CategoryLevel2Detail();
            categoryLevel2Detail.setCategoryLevel2DetailName(item);
            categoryLevel2Detail.setCategoryLevel2(currentCategoryLevel2);
            categoryLevel2Details.add(categoryLevel2DetailService.saveCategoryLevel2Detail(categoryLevel2Detail));
        }
        System.out.println(categoryLevel2Details);
        return categoryLevel2Details ;
    }


    @PostMapping("addCategoryQuantity")
    public List<CategoryQuantity> addCategoryQuantity(@RequestBody CategoryQuantityDTO categoryQuantityDTO)
    {
        List<CategoryQuantity> listToReturn = new ArrayList<>();
        CategoryQuantity categoryQuantity =  new CategoryQuantity();
        categoryQuantity.setCategoryLevel1Detail(categoryQuantityDTO.getCategoryLevel1Detail());
        categoryQuantity.setCategoryLevel2Detail(categoryQuantityDTO.getCategoryLevel2Detail());
        categoryQuantity.setProduct(currentProduct);
        categoryQuantity.setQuantity(categoryQuantityDTO.getQuantity());
        categoryQuantityService.saveCategoryQuantity(categoryQuantity);
//        handle at here
        return listToReturn;
    }


    @PostMapping("setTotalQuantity")
    public Product setCategoryQuantity(@RequestParam Integer totalQuantity){
        currentProduct.setTotalQuantity(totalQuantity);
        productService.saveProduct(currentProduct);
        return currentProduct;
    }
}


