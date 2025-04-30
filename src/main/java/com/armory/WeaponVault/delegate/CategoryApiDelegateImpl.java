package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entity.Category;
import com.armory.WeaponVault.entity.Manufacturer;
import com.armory.WeaponVault.entityDTO.CategoryDto;
import com.armory.WeaponVault.entityDTO.CategoryDtoInsert;
import com.armory.WeaponVault.organizationApi.CategoryApiDelegate;
import com.armory.WeaponVault.service.CategoryService;
import com.armory.WeaponVault.mapper.CategoryMapper;
import com.armory.WeaponVault.service.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryApiDelegateImpl implements CategoryApiDelegate {

    private static final Logger logger = LoggerFactory.getLogger(CategoryApiDelegateImpl.class);

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final ManufacturerService manufacturerService;

    @Autowired
    public CategoryApiDelegateImpl(CategoryService categoryService, CategoryMapper categoryMapper, ManufacturerService manufacturerService) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.manufacturerService = manufacturerService;
    }

    // Create a new category
    @Override
    public ResponseEntity<CategoryDtoInsert> createCategory(String xTenantID, CategoryDtoInsert categoryDtoInsert) {
        try {
            String categoryName = categoryDtoInsert.getCategoryName().trim();
            Optional<Category> existingCategory = categoryService.getCategoryByName(categoryName);

            if (existingCategory.isPresent()) {
                logger.info("Category with name '{}' already exists. Returning conflict response.", categoryName);
                return new ResponseEntity<>(categoryMapper.mapToDtoInsertFromCategory(existingCategory.get()), HttpStatus.CONFLICT);
            }

            Category category = categoryMapper.mapToCategoryFromDtoInsert(categoryDtoInsert);
            if (category.getCreatedAt() == null) {
                category.setCreatedAt(LocalDateTime.now());
            }

            // Handling Manufacturer IDs
            List<Long> manufacturerIds = categoryDtoInsert.getManufacturerIds();
            if (manufacturerIds != null && !manufacturerIds.isEmpty()) {
                List<Manufacturer> manufacturers = manufacturerService.getManufacturersByIds(manufacturerIds);
                category.setManufacturers(manufacturers);

            }

            Category savedCategory = categoryService.saveCategory(category);

            CategoryDtoInsert responseDto = categoryMapper.mapToDtoInsertFromCategory(savedCategory);

            logger.info("Successfully created category with ID '{}'", savedCategory.getCategoryId());
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

        } catch (Exception e) {
            logger.error("Error occurred while creating category: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a category by ID
    @Override
    public ResponseEntity<Void> deleteCategory(Long categoryId, String xTenantID) {
        try {
            boolean isDeleted = categoryService.deleteCategory(categoryId);
            if (isDeleted) {
                logger.info("Successfully deleted category with ID '{}'", categoryId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                logger.warn("Category with ID '{}' not found. Deletion failed.", categoryId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting category with ID '{}': {}", categoryId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all categories
    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories(String xTenantID) {
        try {
            List<Category> categories = categoryService.getAllCategories();

//            List<CategoryDto> responseDtos = categories.stream()
//                    .map(categoryMapper::toDto)
//                    .collect(Collectors.toList());
            List<CategoryDto> responseDtos = categoryMapper.toDtoList(categories);

            logger.info("Successfully retrieved {} categories.", categories.size());
            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching all categories: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get category by ID
    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Long categoryId, String xTenantID) {
        try {
            Optional<Category> category = categoryService.getCategoryById(categoryId);
            System.out.println(category+"categoriessss");
            if (category.isPresent()) {
                CategoryDto responseDto = categoryMapper.toDto(category.get());

                logger.info("Successfully retrieved category with ID '{}'", categoryId);

                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                logger.warn("Category with ID '{}' not found.", categoryId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while fetching category with ID '{}': {}", categoryId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a category by ID
    @Override
    public ResponseEntity<CategoryDtoInsert> updateCategory(Long categoryId, String xTenantID, CategoryDtoInsert categoryDtoInsert) {
        try {
            Optional<Category> existingCategory = categoryService.getCategoryById(categoryId);

            if (existingCategory.isPresent()) {
                Category category = existingCategory.get();
                category.setCategoryName(categoryDtoInsert.getCategoryName());
                category.setCategoryDetails(categoryDtoInsert.getCategoryDetails());
                category.setUpdatedAt(LocalDateTime.now());


                // Handling Manufacturer IDs
                List<Long> manufacturerIds = categoryDtoInsert.getManufacturerIds();
                if (manufacturerIds != null && !manufacturerIds.isEmpty()) {
                    List<Manufacturer> manufacturers = manufacturerService.getManufacturersByIds(manufacturerIds);
                    category.setManufacturers(manufacturers);
                }
                Category updatedCategory = categoryService.updateCategory(category);
                CategoryDtoInsert responseDto = categoryMapper.mapToDtoInsertFromCategory(updatedCategory);
                logger.info("Successfully updated category with ID '{}'", categoryId);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                logger.warn("Category with ID '{}' not found. Update failed.", categoryId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while updating category with ID '{}': {}", categoryId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
