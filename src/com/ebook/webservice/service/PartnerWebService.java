package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.ebook.webservice.representation.CancelOrderDetailRequest;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.AcceptPaymentCustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailDeliveredRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

@WebService
public interface PartnerWebService {

	public CustomerOrderRepresentation acceptPayment(AcceptPaymentCustomerOrderRequest customerOrderRequest);

	public CustomerOrderRepresentation fulfillOrder(AcceptPaymentCustomerOrderRequest customerOrderRequest);

	public OrderDetailRepresentation shipOrder(ShipOrderDetailRequest shipOrderDetailRequest);

	public OrderDetailRepresentation cancelOrder(CancelOrderDetailRequest cancelOrderDetailRequest);

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);

	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest);

	public ProductRepresentation createProduct(ProductRequest productRequest);

	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(Long partnerId,
			String orderState);

	public OrderDetailRepresentation deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest);

}
