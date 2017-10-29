package com.ebook.webservice.workflow;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.model.item.Partner;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.item.PartnerService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.service.order.OrderDetailService;
import com.ebook.webservice.representation.CancelOrderDetailRequest;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

@Service
public class PartnerActivityImpl implements PartnerActivity {

	@Autowired
	private PartnerService partnerService;
	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired
	private OrderDetailService orderDetailService;

	@Override
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		return new PartnerRepresentation(
				partnerService.save(new Partner(null, partnerRequest.getName(), partnerRequest.getUserName(),
						AppBaseUtilsWeb.encriptText(partnerRequest.getPassword()), new ArrayList<>())));
	}

	@Override
	public CustomerOrderRepresentation acceptPayment(CustomerOrderRequest customerOrderRequest) {
		CustomerOrder customerOrder = customerOrderService.getById(customerOrderRequest.getCustomerOrderId());
		customerOrderService.acceptPayment(customerOrder);
		return new CustomerOrderRepresentation(customerOrder);
	}

	@Override
	public CustomerOrderRepresentation fulfillOrder(CustomerOrderRequest customerOrderRequest) {
		CustomerOrder customerOrder = customerOrderService.getById(customerOrderRequest.getCustomerOrderId());
		customerOrderService.fulfillOrder(customerOrder);
		return new CustomerOrderRepresentation(customerOrder);
	}

	@Override
	public OrderDetailRepresentation shipOrder(ShipOrderDetailRequest shipOrderDetailRequest) {
		OrderDetail orderDetail = orderDetailService.getById(shipOrderDetailRequest.getOrderDetailId());
		String trackingNumber = shipOrderDetailRequest.getTrackingNumber();
		orderDetailService.shipOrderDetail((ShippingOrder)orderDetail, trackingNumber);
		return new OrderDetailRepresentation(orderDetail);
	}

	@Override
	public OrderDetailRepresentation cancelOrder(CancelOrderDetailRequest cancelOrderDetailRequest) {
		OrderDetail orderDetail = orderDetailService.getById(cancelOrderDetailRequest.getOrderDetailId());
		CustomerOrder customerOrder = customerOrderService.getById(cancelOrderDetailRequest.getOrderId());
		customerOrderService.cancelOrderDetail(customerOrder, orderDetail);
		return new OrderDetailRepresentation(orderDetail);
	}

}
