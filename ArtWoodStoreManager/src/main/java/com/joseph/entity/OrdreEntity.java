package com.joseph.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrdreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany
    private Set<Product> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Getters and setters for client, products, and status

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

