package com.example.shoppingdemo.restController;

import com.example.shoppingdemo.entity.Product;
import com.example.shoppingdemo.entity.Supplier;
import com.example.shoppingdemo.exception.FoundException;
import com.example.shoppingdemo.exception.NotFoundException;
import com.example.shoppingdemo.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    static Logger log = Logger.getLogger(ProductRestController.class.getName());

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService){
        productService=theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll(){

        return productService.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable int id){
        Product product=null;
        try {
            if(!productService.idExist(id)){

                throw new NotFoundException();
            }
            product=productService.findById(id);

        }catch (NotFoundException ex){
            log.error("Product id not found in db ");
            throw new NotFoundException("Product Id not Found "+id);

        }
        return product;
    }
    @PostMapping("/products")
    public Product save(@RequestBody Product theProduct){
        try {
            productService.save(theProduct);

        }catch (FoundException ex){
            log.error("Product id Already Exist in db ");
            throw new FoundException("Product Id Already Exist "+theProduct.getId());

        }
        return theProduct;
    }

    @PutMapping("/products")
    public Product update(@RequestBody Product theProduct){
        int id=theProduct.getId();
        try {
            if(!productService.idExist(id)) {
                throw new NotFoundException();
            }
            productService.save(theProduct);

        }catch (NotFoundException ex){
            log.error("Product id not found in db ");
            throw new NotFoundException("Product Id not Found "+id);

        }
        return theProduct;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id){
        try{
            if(!productService.idExist(id)){
                throw new NotFoundException();
            }
            productService.delete(id);
        }catch (NotFoundException ex){
            log.error("Product id not found in db ");
            throw new NotFoundException("Product Id not Found "+id);
        }
    }
}
