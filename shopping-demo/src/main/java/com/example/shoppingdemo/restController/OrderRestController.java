package com.example.shoppingdemo.restController;

import com.example.shoppingdemo.entity.Orders;
import com.example.shoppingdemo.exception.FoundException;
import com.example.shoppingdemo.exception.NotFoundException;
import com.example.shoppingdemo.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    static Logger log = Logger.getLogger(OrderRestController.class.getName());

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService theOrderService){
        orderService=theOrderService;
    }


    @GetMapping("/orders")
    public List<Orders> findAll(){
        return orderService.findAll();
    }
    @GetMapping("/orders/{id}")
    public Orders findById(@PathVariable int id){
        Orders order=null;
        try {
            order=orderService.findById(id);

        }catch (NotFoundException ex){
            log.error("Order id not found in db ");
            throw new NotFoundException("Order Id not Found "+id);

        }
        return order;
    }
    @PostMapping("/orders")
    public Orders save(@RequestBody Orders theOrder){
        try {
            orderService.save(theOrder);

        }catch (FoundException ex){
            log.error("Order id Already Exist in db ");
            throw new FoundException("Order Id Already Exist "+theOrder.getId());

        }
        return theOrder;
    }

    @PutMapping("/orders")
    public Orders update(@RequestBody Orders theOrder){
        int id=0;
        try {
            if(!orderService.idExist(id)) {
                throw new NotFoundException();
            }
            orderService.save(theOrder);

        }catch (NotFoundException ex){
            log.error("Order id not found in db ");
            throw new NotFoundException("Order Id not Found "+id);

        }
        return theOrder;
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable int id){
        try{
            orderService.deleteById(id);
        }catch (NotFoundException ex){
            log.error("Order id not found in db ");
            throw new NotFoundException("Order Id not Found "+id);
        }
    }
}
