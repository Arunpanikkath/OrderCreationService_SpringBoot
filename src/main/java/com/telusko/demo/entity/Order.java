package com.telusko.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;


@Entity
@Table(name="orders")
public class Order {
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	
	@Column(nullable =false,unique = true)
	private String orderNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus orderStatus;
	
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<OrderItem> items = new ArrayList<>();
	
	
	@Column(nullable=false)
	private BigDecimal totalamount;


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public List<OrderItem> getItems() {
		return items;
	}


	public void setItems(List<OrderItem> items) {
		this.items = items;
	}


	public BigDecimal getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(BigDecimal totalamount) {
		this.totalamount = totalamount;
	}
	
	
	 
}
