package com.onlineStoreBackend.service;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.Address;
import com.onlineStoreBackend.model.User;
import com.onlineStoreBackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@EnableJpaRepositories("com.onlineStoreBackend.repository")
@EntityScan("com.onlineStoreBackend.model")
public class AddressService  {
    @Autowired
    private AddressRepository addressRepository;

    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getBillingAddress(User user) throws ResourceNotFoundException {
        return  addressRepository.findBillingAddress(user);
    }
    public List<Address> getUserShippingAddresses(User user){
        return addressRepository.findUserShippingAddresses(user);
    }

}
