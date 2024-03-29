package com.kreitek.store.domain.persistence;

import com.kreitek.store.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category saveCategory(Category categoryId);
    void deleteCategory(Long categoryId);
}
