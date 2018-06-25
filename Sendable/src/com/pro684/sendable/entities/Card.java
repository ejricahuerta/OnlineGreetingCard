package com.pro684.sendable.entities;

public class Card  extends BaseEntity {
	
	String Name;
	String Description;
	
	
	public Card() {}
	
	public Card(String name,String desc) {
		this.Name  = name;
		this.Description = desc;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public String getName() {
		return this.Name;
	}
}
