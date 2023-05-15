package com.example.amusetravelproejct.service;

import com.example.amusetravelproejct.dto.request.AdminPageRequest;
import com.example.amusetravelproejct.dto.response.AdminPageResponse;
import com.example.amusetravelproejct.repository.DisplayCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DisplayCategoryService {
    private final DisplayCategoryRepository displayCategoryRepository;
    public List<AdminPageResponse.categoryDetail> processRegisterCategory(AdminPageRequest.categoryRegister categoryRegisterDto, AdminService adminService) {

//        List<AdminPageRequest.categoryDetail> categoryDetails = categoryRegisterDto.getHashTags();
//        Admin admin = adminService.getAdminByEmail(categoryRegisterDto.getManageBy()).orElseThrow(() -> new CustomException(ErrorCode.ADMIN_NOT_FOUND));
        List<AdminPageResponse.categoryDetail> categoryDetailList = new ArrayList<>();



//        categoryDetails.forEach(categoryDetail -> {
//            HashTag hashTag = hashTagRepository.findByHashTag(categoryDetail.getHashTag()).orElseThrow( () -> new CustomException(ErrorCode.HASH_TAG_NOT_FOUND));
//            Category displayCategory = displayCategoryRepository.findByHashTag(hashTag).isEmpty() ? null : displayCategoryRepository.findByHashTag(hashTag).orElseThrow(() -> new CustomException(ErrorCode.DISPLAY_CATEGORY_NOT_FOUND));
//            if (displayCategory == null){
//                displayCategory = new Category();
//                displayCategory.setAdmin(admin);
//                displayCategory.setHashTag(hashTag);
//                displayCategory.setSequence(categoryDetail.getSequence());
//                displayCategory = displayCategoryRepository.save(displayCategory);
//                categoryDetailList.add(new AdminPageResponse.categoryDetail(displayCategory.getId(), hashTag.getHashTag(),
//                        displayCategory.getSequence(),displayCategory.getCreatedDate(),displayCategory.getAdmin().getEmail(),null,""));
//
//            }else{
//
//                displayCategory.setUpdateAdmin(admin);
//                displayCategory.setHashTag(hashTag);
//                displayCategory.setSequence(categoryDetail.getSequence());
//                displayCategory = displayCategoryRepository.save(displayCategory);
//                categoryDetailList.add(new AdminPageResponse.categoryDetail(displayCategory.getId(), hashTag.getHashTag(),
//                        displayCategory.getSequence(),displayCategory.getCreatedDate(),displayCategory.getAdmin().getEmail(),displayCategory.getModifiedDate(),displayCategory.getUpdateAdmin().getEmail()));
//
//            }
//        });

        return categoryDetailList;
    }


}