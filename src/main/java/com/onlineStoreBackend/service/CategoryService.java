package com.onlineStoreBackend.service;

import com.onlineStoreBackend.model.Category;
import com.onlineStoreBackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tekane
 */
@Service
public class CategoryService {


    private static List<Category> categories = new ArrayList<>();

    static {
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("TV");
        category1.setDescription("Testing categories");
        category1.setImageUrl("tk.jpg");

        Category category2 = new Category();
        category2.setId(1);
        category2.setName("Mobile");
        category2.setDescription("Testing categories");
        category2.setImageUrl("mobile.jpg");
        categories.add(category2);
        categories.add(category1);
    }


    public List<Category> getCategories(){
        return  categories;
    }
}
