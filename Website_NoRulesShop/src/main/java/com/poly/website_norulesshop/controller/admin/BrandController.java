package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Brand;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.BrandService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
        brand.setIsActive(true);
        brandService.saveBrand(brand);
        return brand;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("fileName") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String directoryPath = "src/main/resources/static/admin/images/";
                Path path = Paths.get(directoryPath);


                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(directoryPath, fileName);
                Files.write(filePath, file.getBytes());


                String userHome = System.getProperty("user.home");
                String directoryPath1 = userHome + File.separator + "imagesBrand/";
                Path path1 = Paths.get(directoryPath1);

                if (!Files.exists(path1)) {
                    Files.createDirectories(path1);
                }

                String fileName1 = file.getOriginalFilename(); //
                Path filePath1 = Paths.get(directoryPath1, fileName1);
                Files.write(filePath1, file.getBytes());

                String imagePath = fileName1;
                Brand brand = new Brand();
                brand.setLogoUrl(imagePath);
                return ResponseEntity.ok("{\"message\": \"Tải ảnh lên thành công.\", \"imagePath\": \"" + imagePath + "\"}");
            } else {
                return ResponseEntity.ok("{\"message\": \"Không có file ảnh mới được cung cấp.\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tải ảnh lên.");
        }
    }

    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) throws MalformedURLException {
        String userHome = System.getProperty("user.home");
        Resource resource = new UrlResource("file:" + userHome + File.separator + "imagesBrand/" + fileName);

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{brandId}")
    public Brand put(@PathVariable("brandId") Integer id, @RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping("{brand_id}")
    public void delete(@PathVariable("brand_id") Integer id) {
        Brand brand = brandService.getBrandById(id);
        brand.setIsActive(false);
        brandService.saveBrand(brand);
    }

}