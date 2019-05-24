package com.onlineStoreBackend.repository;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("From User as u where u.email = :email")
    User findByEmail(String email) throws ResourceNotFoundException;
}
