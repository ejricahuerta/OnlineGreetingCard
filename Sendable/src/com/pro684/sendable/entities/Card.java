package com.pro684.sendable.entities;

public class Card {

	int Id;
	String Name;
	String Description;
	double Price;
	boolean Available;
	String DateAdded;

	public Card() {
		this.Price = 0.0;
		this.DateAdded = DateTime.GetCurrentDate();
	}

	public Card(String name, String desc, double Price) {
		if (name.isEmpty() && desc.isEmpty()) {
			this.DateAdded = DateTime.GetCurrentDate();
			this.Name = name;
			this.Description = desc;
			this.Available  =  true;
		}
	}

	public String getDescription() {
		return this.Description;
	}

	public String getName() {
		return this.Name;
	}

	public double getPrice() {
		return this.Price;
	}
	
	public void setAvailable(boolean isTrue) {
		this.Available = isTrue;
	}
}
