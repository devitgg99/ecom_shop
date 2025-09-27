package org.example.springwiththymleft.controller;

import lombok.RequiredArgsConstructor;
import org.example.springwiththymleft.model.Response.ApiResponse;
import org.example.springwiththymleft.model.entity.FileMetadata;
import org.example.springwiththymleft.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/upload-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<FileMetadata>> uploadFile(@RequestParam MultipartFile files){
        ApiResponse<FileMetadata> apiResponse = ApiResponse.<FileMetadata>builder()
                .success(true)
                .message("Upload Successfully")
                .payload(fileService.uploadFile(files))
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
