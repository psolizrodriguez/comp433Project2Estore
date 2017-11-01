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
import com.ebook.model.order.PickUpOrder;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.customer.CustomerService;
import com.ebook.service.item.InventoryService;
import com.ebook.service.order.AddressService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.service.order.OrderDetailService;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.OrderDetailRequest;
import com.ebook.webservice.representation.PaymentMethodRequest;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

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
	@Autowired
	private OrderDetailService orderDetailService;

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
	public List<CustomerOrderRepresentation> getOrdersByCustomerId_OrderState(Long customerId, String orderState) {
		List<CustomerOrder> listOrders = new ArrayList<>();
		List<CustomerOrderRepresentation> customerOrderRepresentation = new ArrayList<>();
		if (orderState != null) {
			listOrders = customerOrderService.listAllOrdersByCustomerId_OrderStatus(customerId, orderState);
		} else {
			listOrders = customerOrderService.listAllOrdersByCustomerId(customerId);
		}
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
				OrderDetail aux = null;
				if (orderDetailRequest.getAddressId() != null) {
					aux = new ShippingOrder(null, inventoryService.getById(orderDetailRequest.getInventoryId()),
							orderDetailRequest.getQuantity(), AppBaseConstantsWeb.ORDER_STATUS_PENDING,
							addressService.getById(orderDetailRequest.getAddressId()), null);
				} else {
					aux = new PickUpOrder(null, inventoryService.getById(orderDetailRequest.getInventoryId()),
							orderDetailRequest.getQuantity(), AppBaseConstantsWeb.ORDER_STATUS_PENDING);
				}

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
	
	@Override
	public CustomerOrderRepresentation acceptPayment(Long customerOrderId) {
		CustomerOrder customerOrder = customerOrderService.getById(customerOrderId);
		customerOrderService.acceptPayment(customerOrder);
		return new CustomerOrderRepresentation(customerOrder);
	}
	
	@Override
	public CustomerOrderRepresentation fulfillOrder(Long customerOrderId) {
		CustomerOrder customerOrder = customerOrderService.getById(customerOrderId);
		customerOrderService.fulfillOrder(customerOrder);
		return new CustomerOrderRepresentation(customerOrder);
	}

	@Override
	public OrderDetailRepresentation shipOrder(Long orderDetailId, ShipOrderDetailRequest shipOrderDetailRequest) {
		OrderDetail orderDetail = orderDetailService.getById(orderDetailId);
		String trackingNumber = shipOrderDetailRequest.getTrackingNumber();
		orderDetailService.shipOrderDetail((ShippingOrder) orderDetail, trackingNumber);
		return new OrderDetailRepresentation(orderDetail);
	}

	@Override
	public OrderDetailRepresentation cancelOrder(Long customerOrderId, Long orderDetailId) {
		OrderDetail orderDetail = orderDetailService.getById(orderDetailId);
		customerOrderService.cancelOrderDetail(customerOrderService.getById(customerOrderId), orderDetailId);
		orderDetail = orderDetailService.getById(orderDetailId);
		return new OrderDetailRepresentation(orderDetail);
	}
}
