package com.example.amusetravelproejct.repository.custom;

import com.example.amusetravelproejct.domain.Item;
import com.example.amusetravelproejct.dto.response.MainPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemRepositoryCustom {

    List<Item> find10BestItem();
    List<Item> find10CurrentItem();

    List<Item> find10CategoryBestItem(Long category_id);

    List<Item> find10CategoryCurrentItem(Long category_id);

    Page<Item> findCategoryAllItemPage(Long category_id, Pageable pageable);
}