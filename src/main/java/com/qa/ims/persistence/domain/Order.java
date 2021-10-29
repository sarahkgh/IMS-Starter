package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	private long orderId;
	private Customer customer;
	private long orderQuantity;
	private Item item;

	public Order(long orderId, Customer customer, long orderQuantity, Item item) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderQuantity = orderQuantity;
		this.item = item;
	}

	public Order(long orderId, long orderQuantity) {
		this.setOrderId(orderId);
		this.setOrderQuantity(orderQuantity);
	}

	
	public Order(Customer customer, long orderQuantity) {
		super();
		this.customer = customer;
		this.orderQuantity = orderQuantity;
	}

	public Order(long orderId, Item item) {
		super();
		this.orderId = orderId;
		this.item = item;
	}

	public Order(long orderId, long orderQuantity, Item item) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.item = item;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderQuantity=" + orderQuantity + ", item="
				+ item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, item, orderId, orderQuantity);
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
		return Objects.equals(customer, other.customer) && Objects.equals(item, other.item) && orderId == other.orderId
				&& orderQuantity == other.orderQuantity;
	}

}
