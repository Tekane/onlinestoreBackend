package com.onlineStoreBackend.service;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.User;
import com.onlineStoreBackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
@Service
@EnableJpaRepositories("com.onlineStoreBackend.repository")
@EntityScan("com.onlineStoreBackend.model")
public class UserService {
    @Autowired
    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(User user){
        userRepository.save(user);
    }

    public User getByEmail(String email) throws ResourceNotFoundException{
        User user = userRepository.findByEmail(email);
        return  user;
    }

    public void upadateUser(User user){
            User updateUser = userRepository.findByEmail(user.getEmail());
            updateUser.setLastName(user.getLastName());
            updateUser.setFirstName(user.getFirstName());
            updateUser.setPassword(user.getPassword());
            updateUser.setContactNumber(user.getContactNumber());
            updateUser.setEmail(user.getEmail());
            updateUser.setEnables(user.isEnables());
            updateUser.setCart(user.getCart());
            updateUser.setRole(user.getRole());
            userRepository.save(updateUser);

    }

}
