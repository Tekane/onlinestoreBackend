package com.onlineStoreBackend;

import com.onlineStoreBackend.model.Product;
import com.onlineStoreBackend.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestCase {

    @Autowired
    private ProductService productService;

    //@Test
    public void addProduct(){
        Product product = new Product();
        product.setName("Watch");
        product.setBrand("Tempo");
        product.setDescription("Water resistant watch");
        product.setUnitPrice(500);
        product.setCategoryId(2);
        product.setSupplierId(2);

        productService.createProduct(product);
    }
    //@Test
    public void getProductById(){
        Product product = productService.getProductById(2);
    }
   // @Test
    public void deleteProduct(){
        productService.deleteProduct(1);
    }
    //@Test
    public  void updateProduct(){
        Product product = new Product();
        product.setName("LG");
        product.setUnitPrice(10000);
        productService.updateProduct(1,product);
    }
   // @Test
    public void getAllActiveProducts(){
        List<Product> products = productService.getActiveProducts();
    }
    @Test
    public void getAllActiveProductsByCategoryId(){
        List<Product> products = productService.getActiveProductsByCategory(2);
    }


}
