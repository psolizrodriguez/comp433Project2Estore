package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.ebook.webservice.representation.AcceptPaymentCustomerOrderRequest;
import com.ebook.webservice.representation.CancelOrderDetailRequest;
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

	public Response acceptPayment(AcceptPaymentCustomerOrderRequest customerOrderRequest);

	public Response fulfillOrder(AcceptPaymentCustomerOrderRequest customerOrderRequest);

	public Response shipOrder(ShipOrderDetailRequest shipOrderDetailRequest);

	public Response cancelOrder(CancelOrderDetailRequest cancelOrderDetailRequest);

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);

	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest);

	public ProductRepresentation createProduct(ProductRequest productRequest);

	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(Long partnerId,
			String orderState);

	public Response deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest);

}
