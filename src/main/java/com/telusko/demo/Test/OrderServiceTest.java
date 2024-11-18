package com.telusko.demo.Test;

import java.math.BigDecimal;
import java.util.Collections;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.telusko.demo.entity.Order;
import com.telusko.demo.entity.OrderItem;
import com.telusko.demo.repository.OrderRepository;
import com.telusko.demo.service.OrderService;

import net.bytebuddy.asm.Advice.This;

public class OrderServiceTest {
	
	
	@InjectMocks
	private OrderService orderService;
	@Mock
	private OrderRepository orderRepository;
	
	public  AutoCloseable orderServiceTest(){
		return MockitoAnnotations.openMocks(this);
	}
	
	public void testcreateorderwithemptyitem() {
		Order order = new Order();
		order.setItems(Collections.emptyList());
		
	}
	
	public void quantityThrows() {
		OrderItem orderItem = new OrderItem();
		orderItem.setQuantity(-1);
		orderItem.setUnitPrice(BigDecimal.TEN);
		
		Order order = new Order();
		
		order.setItems(Collections.singletonList(orderItem));
		
		}
}
