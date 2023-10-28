package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Brand;
import com.poly.website_norulesshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_brand")
public class BrandController {
    @Autowired
    BrandService brandService;


    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAllBrands();
    }
    @PostMapping
    public Brand post(@RequestBody Brand brand) {
//        fix this line
//        brand.setIs_excepted(true);
        brandService.saveBrand(brand);
        return brand;
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("fileName") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String directoryPath = "src/main/resources/static/admin/images/"; // Thay đổi thành đường dẫn của thư mục lưu trữ ảnh
                Path path = Paths.get(directoryPath);

                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(directoryPath, fileName);
                Files.write(filePath, file.getBytes());

                // Lưu đường dẫn của ảnh vào cơ sở dữ liệu
                String imagePath = "images/" + fileName;
                // Lưu imagePath vào cơ sở dữ liệu cho brand hoặc sản phẩm tương ứng
                Brand brand = new Brand();
                brand.setLogoUrl(imagePath);
                return ResponseEntity.ok("{\"message\": \"Tải ảnh lên thành công.\", \"imagePath\": \"" + imagePath + "\"}");
            }else {
                    // Người dùng không cung cấp file ảnh mới, không thay đổi ảnh
                    return ResponseEntity.ok("{\"message\": \"Không có file ảnh mới được cung cấp.\"}");
                }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tải ảnh lên.");
        }
    }
    @PutMapping("{brand_id}")
    public Brand put(@PathVariable("brand_id") Integer id, @RequestBody Brand brand) {
        return brandService.update(brand);
    }
    @DeleteMapping("{brand_id}")
    public void delete(@PathVariable("brand_id") Integer id) {
        Brand brand =  brandService.getBrandById(id);
//        fix this line
//        brand.setIs_excepted(false);
        brandService.saveBrand(brand);
    }
}
