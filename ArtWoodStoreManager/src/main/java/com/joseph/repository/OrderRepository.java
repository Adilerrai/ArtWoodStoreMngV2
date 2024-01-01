package com.joseph.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.entity.OrdreEntity;

public interface OrderRepository extends JpaRepository<OrdreEntity, Long> {
}
