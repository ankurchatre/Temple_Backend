package com.main.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUpload {
    private final String UPLOAD_DIR;

    public ImageUpload() {
        this.UPLOAD_DIR = "uploads";
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public boolean uploadFile(MultipartFile file) {
        try {
            Files.copy(
                file.getInputStream(),
                Paths.get(UPLOAD_DIR, file.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
