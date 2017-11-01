package com.ebook.webservice.workflow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.model.item.Inventory;
import com.ebook.model.item.Partner;
import com.ebook.model.item.Product;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.item.InventoryService;
import com.ebook.service.item.PartnerService;
import com.ebook.service.item.ProductService;
import com.ebook.service.order.OrderDetailService;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailDeliveredRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;

@Service
public class PartnerActivityImpl implements PartnerActivity {

	@Autowired
	private PartnerService partnerService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductService productService;

	@Override
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		return new PartnerRepresentation(partnerService.save(new Partner(null, partnerRequest.getName(),
				partnerRequest.getUserName(), AppBaseUtilsWeb.encriptText(partnerRequest.getPassword()))));
	}

	@Override
	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest) {
		return new InventoryRepresentation(
				inventoryService.save(new Inventory(null, partnerService.getById(inventoryRequest.getPartnerId()),
						productService.getById(inventoryRequest.getProductId()), inventoryRequest.getPrice(),
						inventoryRequest.getQuantity())));
	}

	@Override
	public ProductRepresentation createProduct(ProductRequest productRequest) {
		return new ProductRepresentation(productService
				.save(new Product(null, productRequest.getTitle(), productRequest.getDescription(), null)));
	}

	@Override
	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(Long partnerId,
			String orderState) {
		List<OrderDetailRepresentation> listOrderDetailRepresentation = new ArrayList<>();
		List<OrderDetail> listOrderDetail = null;
		if (orderState == null) {
			listOrderDetail = orderDetailService.listAllByPartnerId(partnerId);
		} else {
			listOrderDetail = orderDetailService.listAllByPartnerId_OrderState(partnerId, orderState);
		}
		if (listOrderDetail != null && listOrderDetail.size() > 0) {
			for (OrderDetail orderDetail : listOrderDetail) {
				listOrderDetailRepresentation.add(new OrderDetailRepresentation(orderDetail));
			}
		}
		return listOrderDetailRepresentation;
	}

	@Override
	public boolean deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest) {
		Calendar delivered = AppBaseUtilsWeb.StringToCalendar(orderDetailDeliveredRequest.getDeliveredTime(),
				AppBaseConstantsWeb.DATETIME_FORMAT);
		OrderDetail orderDetail = orderDetailService.getById(orderDetailDeliveredRequest.getOrderDetailId());
		return orderDetailService.orderDelivered((ShippingOrder) orderDetail, delivered);
	}

}
