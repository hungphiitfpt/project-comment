package com.poly.service;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
// Kế thừa lại lớp interface sử dụng lại các phương thức của lớp interface tạo ra
public class ImageStorageService implements IStorageService{
	// Đây là đường dẫn đến thư mục chứa ảnh
    private final Path storageFolder = Paths.get("uploads");
    //constructor
    public ImageStorageService() {
        try {
        	// Khởi tạo thư mục
            Files.createDirectories(storageFolder);
        }catch (IOException exception) {
        	// Nếu không khởi tạo được thư mục quăng lỗi exception
            throw new RuntimeException("Cannot initialize storage", exception);
        }
    }
    private boolean isImageFile(MultipartFile file) {
        
    	// Lấy tên đuôi của file
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        
        //Trả về đuôi file không có khoảng cách là được viết thường hết
        return Arrays.asList(new String[] {"png","jpg","jpeg", "bmp"})
                .contains(fileExtension.trim().toLowerCase());
    }
    
    //phương thức đọc hình ảnh từ tên ảnh
    @Override
    public byte[] readFileContent(String fileName) {
        try {
            Path file = storageFolder.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
                return bytes;
            }
            else {
                throw new RuntimeException("Could not read file: " + fileName);
            }
        }
        catch (IOException exception) {
            throw new RuntimeException("Could not read file: " + fileName, exception);
        }
    }

}