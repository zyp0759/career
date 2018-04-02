package cn.pingweb.career.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String save(String path, String fileType, MultipartFile file, String userId);
    void download();
}
