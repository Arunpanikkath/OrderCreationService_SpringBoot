package com.telusko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
 
}
