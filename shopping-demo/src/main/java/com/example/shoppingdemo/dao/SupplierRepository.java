package com.example.shoppingdemo.dao;

import com.example.shoppingdemo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SupplierRepository extends JpaRepository<Supplier,Integer> ,SupplierRepositoryCustom{
}
