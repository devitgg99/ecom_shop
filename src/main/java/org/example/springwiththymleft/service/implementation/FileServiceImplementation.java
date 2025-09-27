package org.example.springwiththymleft.service.implementation;

import lombok.SneakyThrows;
import org.example.springwiththymleft.model.entity.FileMetadata;
import org.example.springwiththymleft.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImplementation implements FileService {

    @Value("${spring.file-upload-path}")
    private String pathName;
    @SneakyThrows
    @Override
    public FileMetadata uploadFile(MultipartFile files) {
        Path rootPath = Paths.get(pathName);
        if(!Files.exists(rootPath)){
            Files.createDirectories(rootPath);
        }
        return null;
    }
}
