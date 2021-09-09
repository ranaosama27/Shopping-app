package com.example.shoppingdemo.dao;

import com.example.shoppingdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>,ProductRepositoryCustom {
}
