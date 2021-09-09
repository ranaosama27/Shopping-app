package com.example.shoppingdemo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @CreationTimestamp
    @Column(name = "date",nullable = false, updatable = false,insertable = false)
    private Date date;

    @Column(name = "total_amount")
    private int totalAmount;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Orders(){

    }

    public Orders(Date date, int totalAmount, List<Product> products) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addProduct(Product theProduct){
        if (products==null){
            products=new ArrayList<>();
        }
        products.add(theProduct);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", products=" + products +
                '}';
    }
}
