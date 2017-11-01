package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailDeliveredRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;

public interface PartnerActivity {

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);

	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest);

	public ProductRepresentation createProduct(ProductRequest productRequest);

	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(Long partnerId,
			String orderState);

	public boolean deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest);
}
