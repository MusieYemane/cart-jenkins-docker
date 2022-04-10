package com.mosi.shoppingCart;

import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.domain.Products;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class ShoppingCartAppApplication implements CommandLineRunner {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product prod1= new Product("Iphone 13", 2000.0, "The best phone ever", null);
        prod1.setImages(Arrays.asList("https://www.cricketwireless.com/uiassets/DAPW4264-detail-front.jpg", "https://www.cricketwireless.com/uiassets/DAPW4264-detail-back.jpg"));
        restTemplate().postForObject("http://localhost:8080/products", prod1, Product.class);

        Product prod2= new Product("Samsung 21", 1000.0, "The fastest phone ever", null);
        prod2.setImages(Arrays.asList("https://image-us.samsung.com/SamsungUS/configurator/060321/Configurator-01-Family-Shot-765x465_CNET.jpg"));
        restTemplate().postForObject("http://localhost:8080/products", prod2, Product.class);

        Product prod3= new Product("One Plus 9 pro", 600.0, "The fastest phone ever", null);
        prod3.setImages(Arrays.asList("https://fdn2.gsmarena.com/vv/pics/oneplus/oneplus-nord-1.jpg"));
        restTemplate().postForObject("http://localhost:8080/products", prod3, Product.class);

        Product prod4= new Product( "Nokia 5", 1000.0, "The fastest phone ever", null);
        prod4.setImages(Arrays.asList("https://fdn2.gsmarena.com/vv/pics/nokia/nokia-5-2.jpg"));
        restTemplate().postForObject("http://localhost:8080/products", prod4, Product.class);

        Product prod5= new Product("LG 10", 1000.0, "The fastest phone ever", null);
        prod5.setImages(Arrays.asList("https://image-us.samsung.com/SamsungUS/configurator/060321/Configurator-01-Family-Shot-765x465_CNET.jpg"));
        restTemplate().postForObject("http://localhost:8080/products", prod5, Product.class);


//        *********************** TESTING ALL API*********************

//        System.out.println("-------------Products--------------");
//        System.out.println(restTemplate().getForObject("http://localhost:8080/products", Products.class));
//        Customer cust1= new Customer(1l, "Musie Yemane", "musie", "mosi@1996");
//        restTemplate().postForObject("http://localhost:8080/customer/register", cust1, Customer.class);
//        Customer cust2= new Customer(2l, "Rahel Yemane", "rahel", "rahel@1995");
//        restTemplate().postForObject("http://localhost:8080/customer/register", cust2, Customer.class);

//        System.out.println("------------------Customers------------------");
//        System.out.println(restTemplate().getForObject("http://localhost:8080/customer/login?username=musie&password=mosi@1996", Customer.class));
//
//
//        //Add product 1l to cart of customer id 1l
//        restTemplate().getForObject("http://localhost:8080/customer/"+1l+"/cart/add/"+ 1l+"/"+ 6, Customer.class);
//
//        //get cart of customet 1l
//        System.out.println(restTemplate().getForObject("http://localhost:8080/customer/"+1l+ "/cart", Cart.class));
//
//
//        // remove items from customer 1l
//        restTemplate().getForObject("http://localhost:8080/customer/"+1l+"/cart/remove/"+1l+"/"+ 20, Customer.class);
//
//        //empty cart of customer 1l
//        restTemplate().getForObject("http://localhost:8080/customer/"+1l+"/emptyCart", Customer.class);
//
//
//        //create order
//        Order order1= new Order(1l, 1l, "processing", LocalDate.now(),null);
//        restTemplate().postForObject("http://localhost:8080/order", order1, Order.class);
//
//        //get all orders
//        System.out.println(restTemplate().getForObject("http://localhost:8080/order/"+1l, Orders.class));

    }
}
