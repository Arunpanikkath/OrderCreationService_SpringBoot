package com.telusko.demo.service;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.telusko.demo.entity.Order;
import com.telusko.demo.entity.OrderItem;
import com.telusko.demo.entity.OrderStatus;
import com.telusko.demo.repository.OrderRepository;
import com.telusko.demo.validation.ValidationException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	private  OrderRepository orderRepository;

	public Order createOrder(Order order) {
		validateOrder(order);
		
		order.setOrderNumber(generateOrdernumber());
		order.setOrderStatus(OrderStatus.CREATED);
		order.setCreatedAt(LocalDateTime.now());
		order.setTotalamount(calculateTotalMount(order));
		
		order.getItems().forEach(item->item.setOrder(order));
		
		return orderRepository.save(order);
	}

	private BigDecimal calculateTotalMount(Order order) {
		
		return order.getItems().stream().map(OrderItem::getTotalPrice).
				reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private String generateOrdernumber() {
		
		return "ORD-"+UUID.randomUUID().toString();
	}

	private void validateOrder(Order order) {
		if(order.getItems() ==null || order.getItems().isEmpty()) {
			throw new ValidationException("Order must have atleast one item");
		}
		
		for(OrderItem item:order.getItems()) {
			if(item.getQuantity()<=0) {
				throw new ValidationException("quantity must be positive");
			}
			if(item.getUnitPrice().compareTo(BigDecimal.ZERO)<=0) {
				throw new ValidationException("Unitprice must be positive");
			}
			if(item.getProductCode()==null||item.getProductCode().isEmpty()) {
				throw new ValidationException("productcode must not be empty");
			}
			
			item.setTotalPrice(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
		}
		
	}

}
