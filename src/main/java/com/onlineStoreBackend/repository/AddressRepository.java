package com.onlineStoreBackend.repository;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.Address;
import com.onlineStoreBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("From Address  as add where  add.user =:user and add.billing = TRUE ")
    Address findBillingAddress(User user) throws ResourceNotFoundException;
    @Query("From Address  as add where  add.user =:user and add.shipping = TRUE")
    List<Address> findUserShippingAddresses(User user) throws ResourceNotFoundException;
}
