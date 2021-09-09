package com.example.shoppingdemo.service;

import com.example.shoppingdemo.dao.ProductRepository;
import com.example.shoppingdemo.entity.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    static Logger log = Logger.getLogger(ProductServiceImp.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository theProductRepository){
        productRepository=theProductRepository;
    }



    @Override
    public boolean idExist(int id) {
        log.info("idExist function called to check if id exist in db or not ");
        log.debug("idExist function parameter is id of product");
        return productRepository.idExist(id);
    }

    @Override
    public void save(Product theProduct) {
        log.info("save Function called to create new product in db");
        log.debug("save function is object of product");
        productRepository.save(theProduct);

    }
    @Override
    public void update(Product theProduct) {
        log.info("update Function called to create new product in db");
        log.debug("update function is object of product");
        productRepository.save(theProduct);

    }

    @Override
    public void delete(int id) {
        log.info("delete function called to delete product from db using id ");
        log.debug("delete function parameter is id of product");
        productRepository.deleteById(id);

    }

    @Override
    public Product findById(int theId) {
        log.info("findById Function called to get specific product from db using id");
        log.debug("findById function parameter is id of product");
        Optional<Product> result=productRepository.findById(theId);
        Product theProduct=null;
        if(result.isPresent()){
            theProduct=result.get();
        }
        return theProduct;
    }

    @Override
    public List<Product> findAll() {
        log.info("findAll Function called to get all product from db");
        log.debug("findAll function does not have parameter");
        return productRepository.findAll();
    }
}
