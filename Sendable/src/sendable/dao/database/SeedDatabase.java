package sendable.dao.database;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.entities.User;



public class SeedDatabase {

	
	boolean Seeded = false;
	
	ArrayList<User> AllUsers = new ArrayList<User>();
	ArrayList<Card> AllCards = new ArrayList<Card>();
	ArrayList<Category> AllCategories = new ArrayList<Category>();
	public List<User> AddUsers() {
		if (AllUsers.isEmpty()) {

		}
		return AllUsers;
	}
	
	
	public List<Card> AddCards() {
		if(AllCards.isEmpty()) {
			
		}
		return AllCards;
		
	}

	
	public List<Category> AddCategories() {
		if(AllCategories.isEmpty()) {
			
		}
		return this.AllCategories;
	}
	
	
	
	public boolean IsSeeded() {
		return this.Seeded;
	}
}
