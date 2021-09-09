package com.example.shoppingdemo.service;


import com.example.shoppingdemo.entity.Product;

import java.util.List;

public interface ProductService {


    public boolean idExist(int id);
    public void save(Product theProduct);
    public void update(Product theProduct);
    public void delete(int id);
    public Product findById(int theId);
    public List<Product> findAll();
}
