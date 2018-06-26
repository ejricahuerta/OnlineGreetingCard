package com.pro684.sendable.entities;

public class Payment  extends BaseEntity{
	
	String DateAdded;
	String PaymentType;
	double TotalAmount;
	Card card;
	Address BillingAddress;
	Address ShippingAddress;
}
