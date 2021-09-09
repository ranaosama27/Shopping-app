package com.example.shoppingdemo.service;

import com.example.shoppingdemo.dao.SupplierRepository;
import com.example.shoppingdemo.dao.SupplierRepositoryCustomImpl;
import com.example.shoppingdemo.entity.Supplier;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements SupplierService{

    static Logger log = Logger.getLogger(SupplierServiceImp.class);
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImp(SupplierRepository theSupplierRepository){
        supplierRepository=theSupplierRepository;
    }


    @Override
    public boolean idExist(int id) {
        log.info("idExist function called to check if id exist in db or not ");
        log.debug("idExist function parameter is id of supplier");
        return supplierRepository.idExist(id);
    }

    @Override
    public boolean phoneNumberExist(String phoneNumber) {
        log.info("PhoneNumberExist function called to check if phone number exist in db or not ");
        log.debug("phoneNumberExist function parameter is phone number of supplier");
        return supplierRepository.phoneNumberExist(phoneNumber);
    }
    @Override
    public boolean updatePhoneNumberExist(String phoneNumber,int id) {
        log.info("PhoneNumberExist function called to check if phone number exist in db or not ");
        log.debug("phoneNumberExist function parameter is phone number of supplier");
        return supplierRepository.updatePhoneNumberExist(phoneNumber,id);
    }

    @Override
    public void save(Supplier theSupplier) {
        log.info("save Function called to create new supplier into db");
        log.debug("save function is object of supplier");
        supplierRepository.save(theSupplier);
    }

    @Override
    public void update(Supplier theSupplier) {
        log.info("update Function called to update supplier from db");
        log.debug("update function parameter is object of supplier ");

        supplierRepository.save(theSupplier);
    }

    @Override
    public void delete(int id) {
        log.info("delete function called to delete supplier from db using id ");
        log.debug("delete function parameter is id of supplier");
        supplierRepository.deleteById(id);

    }

    @Override
    public Supplier findById(int theId) {
        log.info("findById Function called to get specific Supplier from db using id");
        log.debug("findById function parameter is id of supplier");
        Optional<Supplier> result=supplierRepository.findById(theId);
        Supplier theSupplier=null;
        if(result.isPresent()){
            theSupplier=result.get();
        }
        return theSupplier;
    }

    @Override
    public List<Supplier> findAll() {
        log.info("findAll Function called to get all Suppliers from db");
        log.debug("findAll function does not have parameter");
        return supplierRepository.findAll();
    }
}
