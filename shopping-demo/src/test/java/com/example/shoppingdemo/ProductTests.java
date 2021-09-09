package com.example.shoppingdemo;


import com.example.shoppingdemo.dao.ProductRepository;
import com.example.shoppingdemo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@DataJpaTest
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProductTest(){
        Product product=new Product("iphone6","gold","mobile",50);
        productRepository.save(product);

    }
}
