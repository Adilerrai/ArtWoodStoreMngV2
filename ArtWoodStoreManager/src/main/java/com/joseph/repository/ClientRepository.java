package com.joseph.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    // You can add custom query methods if needed
}
