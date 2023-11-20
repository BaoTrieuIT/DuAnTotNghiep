package com.poly.website_norulesshop.service;

import java.util.Map;
import java.util.UUID;

import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class FileUploadService {


    String uploadDir = "src\\main\\resources\\static\\admin\\images";
    private static final Object lock = new Object();


    public void saveFiles(Map<String, MultipartFile> fileMap) throws IOException {
        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            String filename = entry.getKey();
            MultipartFile file = entry.getValue();
            saveFile(filename, file);
        }
    }


    private void saveFile(String fileName, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadDir + "\\" + fileName);
                Files.write(path, bytes);
                System.out.println("Lưu Thành Công: " + fileName);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi lưu tệp tin: " + e.getMessage());
        }
    }
}