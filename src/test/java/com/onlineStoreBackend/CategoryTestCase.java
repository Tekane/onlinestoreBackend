package com.onlineStoreBackend;


import com.onlineStoreBackend.model.Category;
import com.onlineStoreBackend.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTestCase {

    @Autowired
    private CategoryService categoryService;

    //@Test
    public void testAddCategory(){
        Category category1 = new Category();
        category1.setName("Camera");
        category1.setDescription("LG");
        category1.setImageUrl("tk.jpg");

        this.categoryService.addCategory(category1);
    }
    //@Test
    public void getCategoryById(){
        Category category =  this.categoryService.getCategoryById(1);
        System.out.println(category.getName());
    }
    //@Test
    public void updateCategory(){

        Category category = this.categoryService.getCategoryById(1);
        category.setName("Accessories");
        category.setDescription("Mobile Speakers");
        category.setImageUrl("testing.jpg");
        this.categoryService.updateCategory(1,category);
    }
    //@Test
    public void deleteCategory(){
        categoryService.deleteCategory(1);
    }
    @Test
    public void getAllActiveCategories(){
        List<Category> categories = categoryService.getActiveCategories();
        for (Category category:categories) {
            System.out.println(category.getName());
            System.out.println(category.getDescription());
        }
    }
}
