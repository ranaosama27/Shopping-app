package com.example.shoppingdemo.service;

import com.example.shoppingdemo.entity.Supplier;

import java.util.List;

public interface SupplierService {

    public boolean idExist(int id);
    public boolean phoneNumberExist(String phoneNumber);
    public boolean updatePhoneNumberExist(String phoneNumber,int id);
    public void save(Supplier theSupplier);
    public void update(Supplier theSupplier);
    public void delete(int id);
    public Supplier findById(int theId);
    public List<Supplier> findAll();

}
