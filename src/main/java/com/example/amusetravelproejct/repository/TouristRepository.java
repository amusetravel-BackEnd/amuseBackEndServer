package com.example.amusetravelproejct.repository;

import com.example.amusetravelproejct.domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository  extends JpaRepository<Tourist, Long> {
}
