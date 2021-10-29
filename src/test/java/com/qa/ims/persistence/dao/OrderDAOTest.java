package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup()

	{
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}

	@Test
	public void testCreate() {
		Customer customer = new Customer(2l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		final Order created = new Order(1l, customer, 5l, item);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		Customer customer = new Customer(2l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		List<Order> expected = new ArrayList<Order>();
		expected.add(new Order(1l, customer, 3l, item));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		Customer customer = new Customer(2l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		assertEquals(new Order(2l, customer, 3l, item), DAO.readLatest());
	}

	@Test
	public void testRead() {
		Customer customer = new Customer(2l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		final long ID = 1l;
		assertEquals(new Order(1l, customer, 3l, item), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		Customer customer = new Customer(2l, "John", "Smith");
		Item item = new Item(1l, "Bag", 3l);
		final Order updated = new Order(1l, customer, 5l, item);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
