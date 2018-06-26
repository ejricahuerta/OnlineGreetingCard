package com.pro684.sendable.entities;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseEntity{

	String Name;
	String Description;
	List<Card> Cards;
	String DateAdded;

	public Category() {
		this.DateAdded = DateTime.GetCurrentDate();
		Cards = new ArrayList<Card>();
	}

	public Category(String name, String description) {
		this.DateAdded = DateTime.GetCurrentDate();
		this.Name = name;
		this.Description = description;
		Cards = new ArrayList<Card>();
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public List<Card> getCards() {
		return this.Cards;
	}

	public void AddCard(Card card) {
		this.Cards.add(card);
	}
	
	public void AddCards(List<Card> card) {
		
	}

}
