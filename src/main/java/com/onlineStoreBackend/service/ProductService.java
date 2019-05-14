package com.onlineStoreBackend.service;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.Product;
import com.onlineStoreBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * @author tekane
 */
@Service
@EntityScan("com.onlineStoreBackend.model")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    public Product getProductById(int productId){
        Product product =  productRepository.findById(productId).orElseThrow(()->
                new ResourceNotFoundException("Product","productId",productId));
        return product;
    }

    public void  createProduct(Product product){
        if (product.getIsActive() == true){
            product.setActive("TRUE");
        }else {
            product.setActive("FALSE");
        }
        productRepository.save(product);
    }

    public void updateProduct(int productId , Product productDetails){
        Product product =  productRepository.findById(productId).orElseThrow(()->
                new ResourceNotFoundException("Product","productId",productId));
        product.setBrand(productDetails.getBrand());
        if (productDetails.getIsActive() == true){
            product.setActive("TRUE");
        }else {
            product.setActive("FALSE");
        }
        product.setCode(productDetails.getCode());
        product.setDescription(productDetails.getDescription());
        product.setName(productDetails.getName());
        product.setPurchases(productDetails.getPurchases());
        product.setQuantity(productDetails.getQuantity());
        product.setSupplierId(productDetails.getSupplierId());
        product.setUnitPrice(productDetails.getUnitPrice());
        product.setViews(productDetails.getViews());
        productRepository.save(product);

    }
    //Setting product to false for soft delete
    public void deleteProduct(int productId){
        Product product =  productRepository.findById(productId).orElseThrow(()->
                new ResourceNotFoundException("Product","productId",productId));
        product.setIsActive(false);

        updateProduct(productId,product);
    }

    //Return all active products
    public List<Product> getActiveProducts() {
        return productRepository.findActiveProducts();
     }
     //Return all active products by category
    public List<Product> getActiveProductsByCategory(int categoryId){
        return productRepository.findActiveProductsByCategory(categoryId);
     }
     //Return all latest active products
    public List<Product> getLatestActiveProducts(int count){
        return  productRepository.findLatestActiveProducts(count);
    }

}
