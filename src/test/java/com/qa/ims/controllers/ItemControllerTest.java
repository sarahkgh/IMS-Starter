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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	@Mock
	private Utils utils;
	@Mock
	ItemDAO dao;
	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final String itemName = "purse";
		final long itemValue = 15l;
		final Item created = new Item(itemName, itemValue);

		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getLong()).thenReturn(itemValue);
		Mockito.when(dao.create(created)).thenReturn(created);
		assertEquals(created, controller.create());
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(3l, "purse", 8l));
		Mockito.when(dao.readAll()).thenReturn(items);
		assertEquals(items, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1l, "purse", 8l);
		Mockito.when(this.utils.getLong()).thenReturn(1l, updated.getItemValue());
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();

		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long itemId = 1l;
		Mockito.when(utils.getLong()).thenReturn(itemId);
		Mockito.when(dao.delete(itemId)).thenReturn(1);

		assertEquals(1l, this.controller.delete());
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(itemId);
	}

}
