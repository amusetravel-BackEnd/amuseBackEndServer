package com.example.amusetravelproejct.dto.request;

import lombok.*;

import java.util.List;

public class MyPageRequest {
    @Data
    public static class setReview {
        private Float rate;
        private String review_content;
        private List<ImageInfo> review_imgs;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class ImageInfo {
//        private Long id;
        private String fileName;
        private String base64Data;
//        private String imgUrl;
    }
}
