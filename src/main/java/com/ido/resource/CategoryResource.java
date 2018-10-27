package com.ido.resource;

import com.ido.entity.BusinessCategory;
import com.ido.entity.BusinessSubCategory;
import com.ido.model.SubCategoryCommand;
import com.ido.repository.CategoryRepository;
import com.ido.repository.SubCategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/company/category")
public class CategoryResource {

    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;

    public CategoryResource(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusinessCategory>> getAllCategories() {
        List<BusinessCategory> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}/subcategory/all")
    public ResponseEntity<List<BusinessSubCategory>> getAllSubCategoryForGivenCategory(@PathVariable int categoryId) {
        List<BusinessSubCategory> subCategories = subCategoryRepository.findByCategory_Id(categoryId);
        return ResponseEntity.ok(subCategories);
    }

    @PostMapping("/{categoryId}/subcategory/add")
    public ResponseEntity<BusinessSubCategory> addSubCategoryToGivenCategory(@RequestBody SubCategoryCommand subCategory,
                                                                             @PathVariable int categoryId) {
        BusinessCategory category = categoryRepository.findById(categoryId).get();
        BusinessSubCategory businessSubCategory = new BusinessSubCategory();
        businessSubCategory.setName(subCategory.getName());
        businessSubCategory.setCategory(category);

        BusinessSubCategory savedSubCategory = subCategoryRepository.save(businessSubCategory);
        return ResponseEntity.ok(savedSubCategory);
    }
}