package com.ebook.webservice.workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.model.item.Inventory;
import com.ebook.model.order.CreditCardPayment;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.PayPalPayment;
import com.ebook.model.order.PaymentMethod;
import com.ebook.service.customer.CustomerService;
import com.ebook.service.item.InventoryService;
import com.ebook.service.order.AddressService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.OrderDetailRequest;
import com.ebook.webservice.representation.PaymentMethodRequest;

@Service
public class OrderActivityImpl implements OrderActivity {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired
	private AddressService addressService;

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

	@Override
	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest) {
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		Double total = 0.0;
		if (customerOrderRequest.getOrderDetails() != null && customerOrderRequest.getOrderDetails().size() > 0) {
			for (OrderDetailRequest orderDetailRequest : customerOrderRequest.getOrderDetails()) {
				OrderDetail aux = new OrderDetail(null, inventoryService.getById(orderDetailRequest.getInventoryId()),
						orderDetailRequest.getQuantity(), AppBaseConstantsWeb.ORDER_STATUS_PENDING);
				listOrderDetail.add(aux);
				total += aux.getSubTotal();
			}
		}
		Double totalPaid = 0.0;
		List<PaymentMethod> listPaymentMethod = new ArrayList<>();
		if (customerOrderRequest.getPaymentMethod() != null && customerOrderRequest.getPaymentMethod().size() > 0) {
			for (PaymentMethodRequest paymentMethodRequest : customerOrderRequest.getPaymentMethod()) {
				if (paymentMethodRequest.getTransactionId() != null) {
					listPaymentMethod.add(new PayPalPayment(null, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING,
							paymentMethodRequest.getSubTotal(), paymentMethodRequest.getTransactionId(),
							paymentMethodRequest.getAccountEmail()));
				} else {
					if (paymentMethodRequest.getCreditCardNumber() != null) {
						listPaymentMethod.add(new CreditCardPayment(null, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING,
								paymentMethodRequest.getSubTotal(), paymentMethodRequest.getCreditCardNumber(),
								paymentMethodRequest.getNameOnCard(), paymentMethodRequest.getSecurityCode(),
								paymentMethodRequest.getValidDate()));
					}
				}
				totalPaid += paymentMethodRequest.getSubTotal();
			}
		}
		CustomerOrder customerOrder = new CustomerOrder(null, listOrderDetail,
				AppBaseConstantsWeb.PAYMENT_STATUS_PENDING,
				customerService.getById(customerOrderRequest.getCustomerId()), AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				addressService.getById(customerOrderRequest.getBillingAddressId()), total, listPaymentMethod);
		customerOrder = customerOrderService.save(customerOrder);
		return new CustomerOrderRepresentation(customerOrder);
	}
}
