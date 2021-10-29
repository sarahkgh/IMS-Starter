package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	private Utils utils;
	@Mock
	OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final long id = 1l;
		final long orderQuantity = 5l;
		final Order created = new Order(id, orderQuantity);

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getLong()).thenReturn(orderQuantity);
		Mockito.when(dao.create(created)).thenReturn(created);
		assertEquals(created, controller.create());
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);

	}
	
	@Test
	public void testReadAll() {
		Customer customer = new Customer(1l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1l, customer, 5l, item));
		Mockito.when(dao.readAll()).thenReturn(orders);
		assertEquals(orders, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Customer customer = new Customer(1l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		Order updated = new Order(1l, customer, 5l, item);
		Mockito.when(this.utils.getLong()).thenReturn(1l, updated.getCustomer().getId(), updated.getOrderQuantity());
		
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long orderId = 1l;
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(dao.delete(orderId)).thenReturn(1);
		
		assertEquals(1l, this.controller.delete());
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(orderId);
	}
	
	
	
	
	
}
