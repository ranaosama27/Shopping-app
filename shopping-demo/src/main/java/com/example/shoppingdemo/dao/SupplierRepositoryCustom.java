package com.example.shoppingdemo.dao;



public interface SupplierRepositoryCustom {

    public boolean idExist(int id);
    public boolean phoneNumberExist(String phoneNumber);
    public boolean updatePhoneNumberExist(String phoneNumber,int id);

}
