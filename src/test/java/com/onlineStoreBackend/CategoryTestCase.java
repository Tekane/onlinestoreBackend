package com.onlineStoreBackend;


import com.onlineStoreBackend.model.Category;
import com.onlineStoreBackend.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTestCase {

    @Autowired
    private CategoryService categoryService;

   // @Test
    public void testAddCategory(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("TV");
        category1.setDescription("Testing categories");
        category1.setImageUrl("tk.jpg");

        this.categoryService.addCategory(category1);
    }
    //@Test
    public void getCategoryById(){
        Category category =  this.categoryService.getCategoryById(1);
        System.out.println(category.getName());
    }
    @Test
    public void updateCategory(){
        Category category = new Category();
        category.setName("TestUpdate");
        category.setDescription("Testing update");
        category.setActive(true);
        category.setImageUrl("testing.jpg");
        this.categoryService.updateCategory(1,category);
    }
}
