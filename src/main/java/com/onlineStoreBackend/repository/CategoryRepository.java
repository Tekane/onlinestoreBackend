package com.onlineStoreBackend.repository;

import com.onlineStoreBackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer>{
    @Query("FROM Category as c where c.active = 'TRUE'")
    List<Category> findAllActiveCategory();
}
