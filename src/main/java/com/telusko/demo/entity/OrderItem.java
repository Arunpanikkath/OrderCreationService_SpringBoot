package com.telusko.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	
		private long id;
		
		private Order order;
		
		private String productCode;
		
		private int quantity;
		
		private BigDecimal unitPrice;
		
		private BigDecimal totalPrice;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public BigDecimal getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(BigDecimal totalPrice) {
			this.totalPrice = totalPrice;
		} 
		
		
}
