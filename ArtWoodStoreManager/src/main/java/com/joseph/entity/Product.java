package com.joseph.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;



    public Product(Long idProd, String name, Double price, Long quantity
            ) {
        this.idProd = idProd;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Product() {
    }

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
