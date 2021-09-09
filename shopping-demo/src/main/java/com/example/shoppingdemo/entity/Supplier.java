package com.example.shoppingdemo.entity;

import com.fasterxml.jackson.annotation.*;
import com.sun.glass.ui.View;
import com.sun.istack.NotNull;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityReference(alwaysAsId = true)
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private int id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Phone Number is mandatory")
    @Size(min = 11, max = 11, message = "Phone Number Must be Contain 11 Numbers")
    @Column(unique = true,name = "phone_number")
    private String phoneNumber;



    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "supplier_product",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns=@JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Supplier(){

    }

    public Supplier( String name,String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product theProduct){
        if(products==null){
            products=new ArrayList<>();
        }
        products.add(theProduct);
    }
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
