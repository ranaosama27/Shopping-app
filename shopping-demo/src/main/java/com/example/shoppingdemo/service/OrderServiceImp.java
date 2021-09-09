package com.example.shoppingdemo.service;

import com.example.shoppingdemo.dao.OrderRepository;
import com.example.shoppingdemo.entity.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{

    static Logger log = Logger.getLogger(OrderServiceImp.class);

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository theOrderRepository){
        orderRepository=theOrderRepository;
    }
    @Override
    public void save(Orders theOrder) {
        log.info("save Function called to create new order in db");
        log.debug("save function is object of order");
        orderRepository.save(theOrder);
    }
    @Override
    public void update(Orders theOrder) {
        log.info("update Function called to create new order in db");
        log.debug("update function is object of order");
        orderRepository.save(theOrder);
    }

    @Override
    public List<Orders> findAll() {
        log.info("findAll Function called to get all order from db");
        log.debug("findAll function does not have parameter");
        return orderRepository.findAll();
    }

    @Override
    public Orders findById(int id) {
        log.info("findById Function called to get specific order from db using id");
        log.debug("findById function parameter is id of order");
        Optional<Orders> result=orderRepository.findById(id);
        Orders theOrder=null;
        if(result.isPresent()){
            theOrder=result.get();
        }
        return theOrder;
    }

    @Override
    public void deleteById(int id) {
        log.info("delete function called to delete order from db using id ");
        log.debug("delete function parameter is id of order");
        orderRepository.deleteById(id);

    }

    @Override
    public boolean idExist(int id) {
        log.info("idExist function called to check if id exist in db or not ");
        log.debug("idExist function parameter is id of order");
        return orderRepository.idExist(id);
    }
}
