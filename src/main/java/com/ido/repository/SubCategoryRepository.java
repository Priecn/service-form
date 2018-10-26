package com.ido.repository;

import com.ido.entity.BusinessSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<BusinessSubCategory, Integer> {
}
