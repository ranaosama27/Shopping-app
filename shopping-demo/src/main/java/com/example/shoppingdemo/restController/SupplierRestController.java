package com.example.shoppingdemo.restController;

import com.example.shoppingdemo.entity.Supplier;
import com.example.shoppingdemo.exception.FoundException;
import com.example.shoppingdemo.exception.NotFoundException;
import com.example.shoppingdemo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SupplierRestController {

    static Logger log = Logger.getLogger(SupplierRestController.class);

    private SupplierService supplierService;

    @Autowired
    public SupplierRestController(SupplierService theSupplierService){
        supplierService=theSupplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> findAll(){

        return supplierService.findAll();
    }
    @GetMapping("/suppliers/{id}")
    public Supplier findById(@PathVariable int id){


        Supplier supplier=null;
        try {
            if(!supplierService.idExist(id)){


                throw new NotFoundException();
            }
            supplier=supplierService.findById(id);

        }catch (NotFoundException ex){
            log.error("Supplier id not found in db ");
            throw new NotFoundException("Supplier Id not Found "+id);

        }
        return supplier;
    }
    @PostMapping("/suppliers")
    public Supplier save(@RequestBody Supplier theSupplier){
        try {
            if(supplierService.phoneNumberExist(theSupplier.getPhoneNumber())){
                throw new NotFoundException();
            }
            supplierService.save(theSupplier);

        }catch (NotFoundException ex){
            log.error("Supplier phone number Already Exist in db ");
            throw new FoundException("Supplier phone number Already Exist "+theSupplier.getId());

        }
        return theSupplier;
    }

    @PutMapping("/suppliers")
    public Supplier update(@RequestBody Supplier theSupplier){
        try {
            if(!supplierService.idExist(theSupplier.getId())) {
                throw new NotFoundException();
            }else if(supplierService.updatePhoneNumberExist(theSupplier.getPhoneNumber(),theSupplier.getId())){
                throw new FoundException();
            }
            supplierService.update(theSupplier);

        }catch (NotFoundException ex){
            log.error("Supplier id not found in db ");
            throw new NotFoundException("Supplier Id not Found "+theSupplier.getId());

        }catch (FoundException ex){
            log.error("Supplier phone number already exist in db ");
            throw new NotFoundException("Supplier phone number already exist"+theSupplier.getPhoneNumber());

        }
        return theSupplier;
    }

    @DeleteMapping("/suppliers/{id}")
    public void delete(@PathVariable int id){
        try{
            if(!supplierService.idExist(id)){
                throw new NotFoundException();
            }
            supplierService.delete(id);
        }catch (NotFoundException ex){
            log.error("Supplier id not found in db ");
            throw new NotFoundException("Supplier Id not Found "+id);
        }
    }
}
