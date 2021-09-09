package com.example.shoppingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import sun.security.util.Password;


@SpringBootApplication

public class ShoppingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingDemoApplication.class, args);
	}

}
