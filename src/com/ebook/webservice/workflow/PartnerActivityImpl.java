package com.ebook.webservice.workflow;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.model.item.Inventory;
import com.ebook.model.item.Partner;
import com.ebook.model.item.Product;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.item.InventoryService;
import com.ebook.service.item.PartnerService;
import com.ebook.service.item.ProductService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.service.order.OrderDetailService;
import com.ebook.webservice.representation.CancelOrderDetailRequest;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

@Service
public class PartnerActivityImpl implements PartnerActivity {

	@Autowired
	private PartnerService partnerService;
	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductService productService;

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
		orderDetailService.shipOrderDetail((ShippingOrder) orderDetail, trackingNumber);
		return new OrderDetailRepresentation(orderDetail);
	}

	@Override
	public OrderDetailRepresentation cancelOrder(CancelOrderDetailRequest cancelOrderDetailRequest) {
		OrderDetail orderDetail = null;
		CustomerOrder customerOrder = customerOrderService.getById(cancelOrderDetailRequest.getOrderId());
		if (customerOrder.getOrderDetails() != null && customerOrder.getOrderDetails().size() > 0) {
			for (int i = 0; i < customerOrder.getOrderDetails().size(); i++) {
				OrderDetail auxOrderDetail = customerOrder.getOrderDetails().get(i);
				if (auxOrderDetail.getOrderDetailId() == cancelOrderDetailRequest.getOrderDetailId()) {
					orderDetail = auxOrderDetail;
				}
			}
		}
		customerOrderService.cancelOrderDetail(customerOrder, orderDetail);
		return new OrderDetailRepresentation(orderDetail);
	}

	@Override
	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest) {
		Inventory inventory = new Inventory(null, productService.getById(inventoryRequest.getProductId()),
				inventoryRequest.getPrice(), inventoryRequest.getQuantity());
		Partner partner = partnerService.getById(inventoryRequest.getPartnerId());
		partner.getInventory().add(inventory);
		partner = partnerService.save(partner);
		return new InventoryRepresentation(partner.getInventory().get(partner.getInventory().size() - 1));
	}

	@Override
	public ProductRepresentation createProduct(ProductRequest productRequest) {
		Product product = new Product(null, productRequest.getTitle(), productRequest.getDescription(), null);
		product = productService.save(product);
		return new ProductRepresentation(product.getProductId(), product.getTitle(), product.getDescription());
	}

}
