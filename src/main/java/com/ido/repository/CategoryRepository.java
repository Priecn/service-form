package com.ido.repository;

import com.ido.entity.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<BusinessCategory, Integer> {
}
