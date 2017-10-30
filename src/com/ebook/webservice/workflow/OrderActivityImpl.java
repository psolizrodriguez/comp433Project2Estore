package com.ebook.webservice.workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.model.item.Inventory;
import com.ebook.model.order.CustomerOrder;
import com.ebook.service.item.InventoryService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.InventoryRepresentation;

@Service
public class OrderActivityImpl implements OrderActivity {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private CustomerOrderService customerOrderService;

	public List<InventoryRepresentation> getProducts(String keywords) {

		List<Inventory> listInventory = new ArrayList<>();
		List<InventoryRepresentation> inventoryRepresentation = new ArrayList<>();
		if (keywords == null) {
			listInventory = inventoryService.listAll();
		} else {
			listInventory = inventoryService.listAllInventoryByKeywords(keywords);
		}

		Iterator<Inventory> it = listInventory.iterator();
		while (it.hasNext()) {
			Inventory inventory = (Inventory) it.next();
			inventoryRepresentation.add(new InventoryRepresentation(inventory));
		}
		return inventoryRepresentation;
	}

	@Override
	public List<CustomerOrderRepresentation> getOrdersByCustomerId(long customerId) {
		List<CustomerOrder> listOrders = new ArrayList<>();
		List<CustomerOrderRepresentation> customerOrderRepresentation = new ArrayList<>();
		listOrders = customerOrderService.listAllOrdersByCustomerId(customerId);
		
		Iterator<CustomerOrder> it = listOrders.iterator();
		while (it.hasNext()) {
			CustomerOrder customerOrder = (CustomerOrder) it.next();
			customerOrderRepresentation.add(new CustomerOrderRepresentation(customerOrder));
		}
		return customerOrderRepresentation;
	}

	@Override
	public List<CustomerOrderRepresentation> getOrdersByCustomerId_OrderState(long customerId, String orderState) {
		List<CustomerOrder> listOrders = new ArrayList<>();
		List<CustomerOrderRepresentation> customerOrderRepresentation = new ArrayList<>();
		listOrders = customerOrderService.listAllOrdersByCustomerId_OrderStatus(customerId, orderState);
		
		Iterator<CustomerOrder> it = listOrders.iterator();
		while (it.hasNext()) {
			CustomerOrder customerOrder = (CustomerOrder) it.next();
			customerOrderRepresentation.add(new CustomerOrderRepresentation(customerOrder));
		}
		return customerOrderRepresentation;
	}
}
