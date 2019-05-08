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

    @Test
    public void testAddCategory(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("TV");
        category1.setDescription("Testing categories");
        category1.setImageUrl("tk.jpg");

        this.categoryService.addCategory(category1);

    }
}
