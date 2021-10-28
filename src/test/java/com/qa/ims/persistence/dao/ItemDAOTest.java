package com.qa.ims.persistence.dao; 

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;


public class ItemDAOTest {
	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup()

	{
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}

	@Test
	public void  testCreate() {

		final Item created = new Item(2l, "Handbag", 10l);

		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<Item>();
		expected.add(new Item(1l, "handbag", 12l));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1l, "handbag", 12l), DAO.readLatest());

	}

	@Test
	public void testRead() {
		final long itemId = 1l;
		assertEquals(new Item(1l, "handbag", 12l), DAO.read(itemId));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1l, "Handbag", 10l);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
