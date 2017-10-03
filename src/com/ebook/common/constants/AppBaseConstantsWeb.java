package com.ebook.common.constants;

public class AppBaseConstantsWeb {
	// Application Constants
	public static int BYTES_FOR_ENCRIPTION = 512;
	public static String KEY_FOR_ENCRIPTION = "EBookStore";
	// PAYMENT STATUS
	public static final String PAYMENT_STATUS_PENDING = "Pending";
	public static final String PAYMENT_STATUS_VERIFIED = "Verified";
	public static final String PAYMENT_STATUS_PAID = "Paid";
	public static final String PAYMENT_STATUS_REFUNDED = "Refunded";
	public static final String PAYMENT_STATUS_PARTIALLY_REFUNDED = "Partially Refunded";
	// ORDER STATUS
	public static final String ORDER_STATUS_PENDING = "Pending";
	public static final String ORDER_STATUS_READY_TO_SHIP = "Ready to Ship";
	public static final String ORDER_STATUS_READY_TO_PICK_UP = "Ready to Pickup";
	public static final String ORDER_STATUS_FULFILLED = "Fulfilled";
	public static final String ORDER_STATUS_SHIPPED = "Shipped";
	public static final String ORDER_STATUS_TRANSIT = "Transit";
	public static final String ORDER_STATUS_DELIVERED = "Delivered";
	public static final String ORDER_STATUS_RETURNED = "Returned";
	public static final String ORDER_STATUS_CANCELED = "Canceled";
	// PICK UP ORDER DETAILS
	public static final String INITIAL_TIME_PICK_UP = "09:00";
	public static final String FINAL_TIME_PICK_UP = "17:00";
}
