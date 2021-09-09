package com.example.shoppingdemo.dao;


import com.example.shoppingdemo.entity.Supplier;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class SupplierRepositoryCustomImpl implements SupplierRepositoryCustom{


    private EntityManager entityManager;

    @Autowired
    public SupplierRepositoryCustomImpl(EntityManager theEntityManager){
        entityManager =theEntityManager;
    }


    @Override
    public boolean idExist(int id) {

        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Supplier where id=:id", Supplier.class).setParameter("id",id);
        return query.uniqueResult()!=null;
    }

    @Override
    public boolean phoneNumberExist(String phoneNumber) {

        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Supplier where phoneNumber=:phoneNumber", Supplier.class)
                .setParameter("phoneNumber",phoneNumber);
        return query.uniqueResult()!=null;
    }
    @Override
    public boolean updatePhoneNumberExist(String phoneNumber,int id){
        Session currentSession=entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Supplier where phoneNumber =:phoneNumber and id!=:id",Supplier.class)
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("id",id);
        return query.uniqueResult() != null;
    }
}
