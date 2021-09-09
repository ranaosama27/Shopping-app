package com.example.shoppingdemo.service;

import com.example.shoppingdemo.entity.Orders;

import java.util.List;

public interface OrderService {

    public void save(Orders theOrder);
    public void update(Orders theOrder);
    public List<Orders> findAll();
    public Orders findById(int id);
    public void deleteById(int id);
    public boolean idExist(int id);
}
