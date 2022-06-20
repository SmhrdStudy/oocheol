package com.smart.project.web.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UploadFile {
    private String uploadFileName;
    private String storeFileName;
}
