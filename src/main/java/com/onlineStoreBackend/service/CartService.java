package com.onlineStoreBackend.service;

import com.onlineStoreBackend.exception.ResourceNotFoundException;
import com.onlineStoreBackend.model.Cart;
import com.onlineStoreBackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories("com.onlineStoreBackend.repository")
@EntityScan("com.onlineStoreBackend.model")
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void createCart(Cart cart){
        cartRepository.save(cart);
    }
    public void updateCard(Cart cart){
        Cart updateCart =  cartRepository.findById(cart.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Cart id","id","cart"));
        updateCart.setUser(cart.getUser());
        updateCart.setCartLines(cart.getCartLines());
        updateCart.setGrandTotal(cart.getGrandTotal());
        cartRepository.save(updateCart);

    }
}
