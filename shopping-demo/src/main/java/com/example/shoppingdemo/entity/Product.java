package com.example.shoppingdemo.entity;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Color is mandatory")
    @Column(name = "color")
    private String color;

    @NotBlank(message = "Category is mandatory")
    @Column(name = "category")
    private String category;

    //@NotBlank(message = "Price is mandatory")
    @Column(name = "price")
    private Integer price;




    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "supplier_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Orders> orders;

    public Product(){

    }

    public Product(String name, String color, String category, Integer price) {
        this.name = name;
        this.color = color;
        this.category = category;
        this.price = price;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void addSupplier(Supplier theSupplier){
        if(suppliers==null){
            suppliers=new ArrayList<>();
        }
        suppliers.add(theSupplier);
    }

    public void addOrder(Orders theOrder){
        if(orders==null){
            orders=new ArrayList<>();
        }
        orders.add(theOrder);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
