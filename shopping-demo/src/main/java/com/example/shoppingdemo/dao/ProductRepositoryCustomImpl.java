package com.example.shoppingdemo.dao;


import com.example.shoppingdemo.entity.Product;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{



    private EntityManager entityManager;

    @Autowired
    public ProductRepositoryCustomImpl(EntityManager theEntityManager){
        entityManager =theEntityManager;
    }



    @Override
    public boolean idExist(int id) {
        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Product where id=:id",Product.class).setParameter("id",id);
        return query.uniqueResult()!=null;
    }
}
