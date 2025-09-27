package org.example.springwiththymleft.service;

import org.example.springwiththymleft.model.entity.FileMetadata;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileMetadata uploadFile(MultipartFile files);
}
