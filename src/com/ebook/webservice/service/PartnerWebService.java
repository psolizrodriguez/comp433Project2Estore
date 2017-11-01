package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailDeliveredRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;

@WebService
public interface PartnerWebService {

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);

	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest);

	public ProductRepresentation createProduct(ProductRequest productRequest);

	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(Long partnerId,
			String orderState);

	public Response deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest);

}
