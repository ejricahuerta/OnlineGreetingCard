package com.pro684.sendable.dtos;
public class CardDto {
	int Id;
	String Name;
	String Description;
	double Price;
	boolean Available;
	String DateAdded;
	
	public CardDto(int id,
			String name, 
			String description, 
			double price, 
			boolean available, 
			String dateAdded) {
		super();
		Id = id;
		Name = name;
		Description = description;
		Price = price;
		Available = available;
		DateAdded = dateAdded;
	}
	
	
	public CardDto() {
	}


	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public boolean isAvailable() {
		return Available;
	}
	public void setAvailable(boolean available) {
		Available = available;
	}
	public String getDateAdded() {
		return DateAdded;
	}
	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}
}
