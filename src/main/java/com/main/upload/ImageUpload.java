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

    // Store uploaded images in /tmp/uploads/ (works on Linux, Windows, cloud)
    private final String UPLOAD_DIR;

    public ImageUpload() {
        this.UPLOAD_DIR = System.getProperty("user.home") + File.separator + "uploads";
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public boolean uploadFile(MultipartFile file) {
        boolean upload = false;
        try {
            Files.copy(
                file.getInputStream(),
                Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );
            upload = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return upload;
    }
}
