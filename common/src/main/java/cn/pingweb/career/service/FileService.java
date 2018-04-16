package cn.pingweb.career.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    String save(String path, MultipartFile file, String userId, String fileName, String submix);
    File download(String path, String fileName);
}
