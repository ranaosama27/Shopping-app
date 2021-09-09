package com.example.shoppingdemo.dao;

import com.example.shoppingdemo.entity.Orders;
import com.example.shoppingdemo.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{

    private EntityManager entityManager;

    @Autowired
    public OrderRepositoryCustomImpl(EntityManager theEntityManager){
        entityManager =theEntityManager;
    }

    @Override
    public boolean idExist(int id) {
        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Orders where id=:id", Orders.class).setParameter("id",id);
        return query.uniqueResult()!=null;
    }
}
