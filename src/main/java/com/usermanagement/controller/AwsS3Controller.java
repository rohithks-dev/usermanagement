package com.usermanagement.controller;

import com.usermanagement.service.AwsS3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/s3file")
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    public AwsS3Controller(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(awsS3Service.uploadFile(file));
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) {
        return ResponseEntity.ok(awsS3Service.downloadFile(fileName));
    }
}
