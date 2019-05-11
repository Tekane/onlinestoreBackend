package com.onlineStoreBackend.service;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.Category;
import com.onlineStoreBackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author tekane
 */
@Service
@EnableJpaRepositories("com.onlineStoreBackend.repository")
@EntityScan("com.onlineStoreBackend.model")
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category getCategoryById(int categoryId){
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category","categoryId",categoryId));
        return category;
    }

    public void addCategory(Category category){
        if (category.getIs_active() == true){
            category.setActive("TRUE");
        }else {
            category.setActive("FALSE");
        }
        this.categoryRepository.save(category);
    }

    public void updateCategory(int categoryId , Category upDatedCategory){
        Category category =  this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        category.setName(upDatedCategory.getName());
        category.setImageUrl(upDatedCategory.getImageUrl());
        if (upDatedCategory.getIs_active() == true){
            category.setActive("TRUE");
        }else {
            category.setActive("FALSE");
        }
        category.setDescription(upDatedCategory.getDescription());

        this.categoryRepository.save(category);
    }

    //Deleting is setting is_active to false
    public void deleteCategory(int categoryId){
        Category category =  this.categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","categoryId",categoryId));
        category.setIs_active(false);

        updateCategory(categoryId,category);


    }
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getActiveCategories(){
        return categoryRepository.findAllActiveCategory();
    }

}
