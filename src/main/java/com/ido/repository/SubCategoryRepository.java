package com.ido.repository;

import com.ido.entity.BusinessSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<BusinessSubCategory, Integer> {

    List<BusinessSubCategory> findByCategory_Id(int categoryId);
}
