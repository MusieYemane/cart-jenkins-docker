package com.mosi.shoppingCart.customer.controller;


import com.mosi.shoppingCart.customer.repository.CustomerRepo;
import com.mosi.shoppingCart.customer.domain.Cart;
import com.mosi.shoppingCart.customer.domain.CartLine;
import com.mosi.shoppingCart.customer.domain.Customer;
import com.mosi.shoppingCart.customer.service.CustomerService;
import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;


    @PostMapping("/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer){
        Optional<Customer> user= customerService.findByUsernameAndAndPassword(customer.getUsername(), customer.getPassword());
        if(user.isPresent()) return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);  //404 bad request
        return ResponseEntity.ok(customerService.addCustomer(customer));  //200 ok
    }


    @GetMapping("/login")  // /?username=musie&password=mosi@1996
    public ResponseEntity<Customer> login(@RequestParam("username") String username, @RequestParam("password") String passsword){
        Optional<Customer> user= customerService.findByUsernameAndAndPassword(username,passsword);
        if(user.isPresent()) return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{userId}/cart")
    public ResponseEntity<Cart> getCustomerCart(@PathVariable("userId") String userId){
        Optional<Customer> customer=customerService.getCustomerById(userId);
        if (!customer.isPresent()){
            System.out.println("Customer not exists");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(customer.get().getCart());
    }


    // add product to cart
    @GetMapping("/{userId}/cart/add/{productId}/{quantity}")
    public ResponseEntity<Customer> addProductToCart(@PathVariable("userId") String userId,
                                                 @PathVariable("productId") String productId,
                                                 @PathVariable("quantity") int quantity){
        Customer customer= customerService.getCustomerById(userId).get();
        Cart cart= customer.getCart();

        //check if product already available in cart, if yes, then just the quantity
        for (CartLine cartLine : cart.getCartLines()){
            Product prod= cartLine.getProduct();
            if(prod.getProductId().equals(productId)) {
                cartLine.setQuantity(cartLine.getQuantity()+quantity);
                return ResponseEntity.ok(customerService.addCustomer(customer));

            }
        }

        //else get the product and add it to cart
        Product product= productService.getProductById(productId).get();
        CartLine cl= new CartLine(product, quantity);
        cart.getCartLines().add(cl);
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    //remove product
    @GetMapping("/{userId}/cart/remove/{productId}/{quantity}")
    public ResponseEntity<Customer> removeProductToCart(@PathVariable("userId") String userId,
                                                     @PathVariable("productId") String productId,
                                                     @PathVariable("quantity") int quantity){
        Customer customer= customerService.getCustomerById(userId).get();
        Cart cart= customer.getCart();


        //check if product already available in cart, if yes, then just the quantity
        for (CartLine cartLine : cart.getCartLines()){

            Product prod= cartLine.getProduct();
            if(prod.getProductId().equals(productId)) {
                if(cartLine.getQuantity()<=1) {
                    //remove cartline
                    cart.removeCartLine(cartLine);
                }else{
                    cartLine.setQuantity(cartLine.getQuantity()-quantity);
                }
                return ResponseEntity.ok(customerService.addCustomer(customer));

            }
        }
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{userId}/emptyCart")
    public ResponseEntity<Customer> emptyCart(@PathVariable("userId") String userId){
        Customer customer= customerService.getCustomerById(userId).get();
        customer.getCart().getCartLines().clear();
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    //to dos
    //remove product from cart

    

    //place an order
}
