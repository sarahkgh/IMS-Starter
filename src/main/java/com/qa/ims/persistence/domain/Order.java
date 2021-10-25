package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	private long orderId;
	private Customer customer;
	private long orderQuantity;

	public Order(long orderId, Customer customer, long orderQuantity) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderQuantity = orderQuantity;
	}

	public Order(long orderId, long orderQuantity) {
		this.setOrderId(orderId);
		this.setOrderQuantity(orderQuantity);
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderQuantity=" + orderQuantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, orderId, orderQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && orderId == other.orderId
				&& orderQuantity == other.orderQuantity;
	}

}
