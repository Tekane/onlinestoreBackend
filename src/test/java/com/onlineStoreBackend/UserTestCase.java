package com.onlineStoreBackend;

import com.onlineStoreBackend.model.Address;
import com.onlineStoreBackend.model.Cart;
import com.onlineStoreBackend.model.User;
import com.onlineStoreBackend.service.AddressService;
import com.onlineStoreBackend.service.CartService;
import com.onlineStoreBackend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestCase {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;

   // @Test
    public void saveUser(){

        User user = new User();
        user.setLastName("Phasha");
        user.setFirstName("Tekane");
        user.setEmail("phasha15@gmail.com");
        user.setContactNumber("0799746253");
        user.setPassword("123456");
        user.setRole("USER");

        //Add user
        userService.createUser(user);

        //Link the user with the address
        Address address = new Address();
        address.setAddressLineOne("213 Farenden ");
        address.setAddressLineTwo("Acardia");
        address.setCity("Pretoria");
        address.setCountry("South africa");
        address.setPostalCode("0083");
        address.setState("Gauteng");
        address.setBilling(true);
        addressService.createAddress(address) ;

        if (user.getRole().equals("USER")){
            //Create a card for this user
            Cart cart = new Cart();
            cart.setUser(user);
            //Add to cart
            cartService.createCart(cart);

            //Add a shipping address for the user
            Address shippingAddress = new Address();
            shippingAddress.setAddressLineOne("05 ");
            shippingAddress.setAddressLineTwo("Mogapeng khayalam");
            shippingAddress.setCity("Polokwane");
            shippingAddress.setCountry("South africa");
            shippingAddress.setPostalCode("0873");
            shippingAddress.setState("Limpopo");
            shippingAddress.setBilling(true);

            //link the address with the user
           addressService.createAddress(shippingAddress) ;

        }
    }
    //@Test
    public void testUserAndCartRelationship(){
        User user = new User();
        user.setLastName("Phasha");
        user.setFirstName("Tekane");
        user.setEmail("phasha15@gmail.com");
        user.setContactNumber("0799746253");
        user.setPassword("123456");
        user.setRole("USER");


        if (user.getRole().equals("USER")){
            Cart cart = new Cart();

            cart.setUser(user);
            //Add user
            user.setCart(cart);

        }
        userService.createUser(user);
    }
   // @Test
    public void updateCart(){
        //Fetch the user by email

        User user = userService.getByEmail("phasha15@gmail.com");

        //Get the cart of the user
        Cart cart =  user.getCart();
        cart.setGrandTotal(20.000);
        cart.setCartLines(2);

        cartService.updateCard(cart);

    }
   // @Test
    public void testCaseForAddress() {
        //add user
        User user = new User();
        user.setLastName("Phasha");
        user.setFirstName("Tekane");
        user.setEmail("phasha15@gmail.com");
        user.setContactNumber("0799746253");
        user.setPassword("123456");
        user.setRole("USER");

        //Add user
        userService.createUser(user);
        //add shipping address
        //Link the user with the address
        Address address = new Address();
        address.setAddressLineOne("213 Farenden ");
        address.setAddressLineTwo("Acardia");
        address.setCity("Pretoria");
        address.setCountry("South africa");
        address.setPostalCode("0083");
        address.setState("Gauteng");
        address.setBilling(true);

        //attach the user to the address

        address.setUser(user);
        addressService.createAddress(address);

        if (user.getRole().equals("USER")) {
            //Create a card for this user
         /*   User user1 =  userService.getByEmail(user.getEmail());

            Cart cart =  user.getCart();*/


            //Add to cart


            //Add a shipping address for the user
            Address shippingAddress = new Address();
            shippingAddress.setAddressLineOne("05 ");
            shippingAddress.setAddressLineTwo("Mogapeng khayalam");
            shippingAddress.setCity("Polokwane");
            shippingAddress.setCountry("South africa");
            shippingAddress.setPostalCode("0873");
            shippingAddress.setState("Limpopo");
            shippingAddress.setShipping(true);

            //link the address with the user
            shippingAddress.setUser(user);
            addressService.createAddress(shippingAddress);

        }
    }
    @Test
    public void testListOfAddresses(){

        User user =  userService.getByEmail("phasha15@gmail.com");

        List<Address> addresses =  addressService.getUserShippingAddresses(user);

        Address address =  addressService.getBillingAddress(user);


    }
}
