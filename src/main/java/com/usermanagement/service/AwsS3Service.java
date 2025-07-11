package com.usermanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface AwsS3Service {

    String uploadFile(MultipartFile file) throws IOException;

    byte[] downloadFile(String fileName);
}
