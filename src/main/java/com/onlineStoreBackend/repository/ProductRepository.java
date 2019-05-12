package com.onlineStoreBackend.repository;
import com.onlineStoreBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    //Business methods
    @Query("FROM Product as pd WHERE pd.active = 'TRUE'")
    List<Product> findActiveProducts();
    @Query("FROM Product as pd WHERE pd.active = 'TRUE' and pd.categoryId = ?1")
    List<Product> findAcitveProductsByCategory(int categoryId);
    @Query("FROM Product as pd where pd.active = 1 order by id")
    List<Product> findLatestActiveProducts(int count);
}
