package com.pro684.sendable.entities;

public class CardLetter extends BaseEntity {
	Card Card;
	String Message;
	String FontStyle;
	String DateAdded;
	Address ShippingAddress;

	public CardLetter(Card card, String message, String font, Address shippingAddress) {
		this.Card = card;
		this.Message = message;
		this.FontStyle = font;
		this.ShippingAddress = shippingAddress;
	}
	
	public Card getCard() {
		return this.Card;
	}
	
	public void setCard(Card card) {
		this.Card = card;
	}
	
	public String getMessage() {
		return this.Message;
	}
	
	public void setMessage(String message) {
		this.Message = message;
	}
	
	public String getFont() {
		return this.FontStyle;
	}
	
	public void setFont(String font) {
		this.FontStyle = font;
	}
	
	public Address getShippingAddress() {
		return this.ShippingAddress;
	}
	
	public void setShippingAddress(Address shippingAddress) {
		this.ShippingAddress = shippingAddress;
	}
}
