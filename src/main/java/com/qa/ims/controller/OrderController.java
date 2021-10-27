package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long id = utils.getLong();
		LOGGER.info("Please enter an order quantity");
		Long orderQuantity = utils.getLong();
		Order order = orderDAO.create(new Order(id, orderQuantity));
		return order;
	}

//	@Override
//	public Order update() {
//		LOGGER.info("Please enter the id of the order you wish to update");
//		Long orderId = utils.getLong();
//
//		LOGGER.info("Please enter an order quantity");
//		Long orderQuantity = utils.getLong();
//		Order order = orderDAO.update(new Order(orderId, orderQuantity));
//		LOGGER.info("Order Updated");
//		return order;
//	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		return orderDAO.delete(orderId);
	}

	@Override
	public Order update() {
		LOGGER.info(
				"ADD if you want to add an item to your order, REMOVE if you would like to remove an item from your order, DONE if you are finished");
		String reply = utils.getString();

		if (reply.equalsIgnoreCase("ADD")) {
			LOGGER.info("Enter the orderId");
			Long orderId = utils.getLong();

			LOGGER.info("Enter the itemId");
			Long itemId = utils.getLong();
			Item item = new Item();
			
			item.setItemId(itemId);
			
			Order order = new Order(orderId, 3l, item);
			return orderDAO.addItem(order);
		} else if (reply.equalsIgnoreCase("REMOVE")) {
			LOGGER.info("Enter the orderId");
			Long orderId = utils.getLong();

			LOGGER.info("Enter the itemId");
			Long itemId = utils.getLong();
			Item item = new Item();
			item.setItemId(itemId);

			Order order = new Order(orderId, item);
			return orderDAO.removeItem(order);
		} else if (reply.equalsIgnoreCase("DONE")) {
			orderDAO.readAll();
		}
		return null;
	}

	@Override
	public Order addItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
