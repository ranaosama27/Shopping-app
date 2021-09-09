package com.example.shoppingdemo.dao;

import com.example.shoppingdemo.entity.Orders;
import com.example.shoppingdemo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer>,OrderRepositoryCustom {
}
