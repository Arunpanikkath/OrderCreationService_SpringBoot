package com.telusko.demo.controller;

import javax.persistence.criteria.Order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.service.OrderService;
import com.telusko.demo.validation.ValidationException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody com.telusko.demo.entity.Order order) {
		try {
			com.telusko.demo.entity.Order createdOrder = orderService.createOrder(order);
			return new ResponseEntity(createdOrder,HttpStatus.CREATED);
			
		}catch (ValidationException e) {
			return ResponseEntity.badRequest().body(null);
		}
		
		
	}
}
