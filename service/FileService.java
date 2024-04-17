package com.work.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

/**
 * @author Jiayu Liu
 */
@Service
@Slf4j
public class FileService {


    @SneakyThrows
    public String upload(MultipartFile file){
        byte[] bytes = file.getBytes();
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }

    public String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            return null;
        }
        int lastIndexOfDot = fileName.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return null;
        }
        return fileName.substring(lastIndexOfDot + 1);
    }
}
