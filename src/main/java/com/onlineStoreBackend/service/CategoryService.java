package com.onlineStoreBackend.service;

import com.onlineStoreBackend.model.Category;
import com.onlineStoreBackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tekane
 */
@Service
@ComponentScan("com.onlineStoreBackend.repository")
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category getCategoryById(int categoryId){
        Category category = this.categoryRepository.getOne(categoryId);
        return category;
    }

    public void addCategory(Category category){
        this.categoryRepository.save(category);
    }

    public void updateCategory(int categoryId , Category upDatedCategory){
        Category category =  this.categoryRepository.getOne(categoryId);
        category.setName(upDatedCategory.getName());
        category.setImageUrl(upDatedCategory.getImageUrl());
        category.setActive(true);
        category.setDescription(upDatedCategory.getDescription());
        this.categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId){
        Category category =  this.categoryRepository.getOne(categoryId);
        this.categoryRepository.delete(category);
    }


}
