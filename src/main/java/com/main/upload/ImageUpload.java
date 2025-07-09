package com.main.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class ImageUpload {
//	private String UPLOAD_DIR="D:\\SpringBoot\\BaraJotirlinga\\src\\main\\resources\\static\\image";
	private String UPLOAD_DIR=new ClassPathResource("static\\image\\").getFile().getAbsolutePath();
	public ImageUpload() throws IOException {
		// TODO Auto-generated constructor stub
	}

	public boolean uploadFile(MultipartFile file) {
		boolean upload=false;
		try {
			
		Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		upload=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return upload;
	}
	
}