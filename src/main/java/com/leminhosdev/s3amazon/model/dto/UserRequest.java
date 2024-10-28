package com.leminhosdev.s3amazon.model.dto;

import org.springframework.web.multipart.MultipartFile;

public record UserRequest(String name, MultipartFile profileImageFile) {
}
