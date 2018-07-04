package sendable.dao.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import sendable.dao.entities.Address;
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
			Address address = new Address("Line 1", "Line 2", "City", "State", "A1A1A1");
			AllUsers.add(new User("Edmel", "Ricahuerta", "password", "exricahuerta@gmail.com", "0000000000", address));
			AllUsers.add(new User("Angelica", "Ricahuerta", "password", "angelica@gmail.com", "0000000000", address));

		}
		return AllUsers;
	}

	public List<Card> AddCards() {
		if (AllCards.isEmpty()) {

		}
		return AllCards;

	}

	public List<Category> AddCategories() {
		if (AllCategories.isEmpty()) {

		}
		return this.AllCategories;
	}

	public boolean IsSeeded() {
		return this.Seeded;
	}

	public static void main(String[] args) {

		EntityManager manager = DatabaseManager.getEntityManager();
		manager.getTransaction().begin();
		SeedDatabase seed = new SeedDatabase();
		for (User u : seed.AddUsers()) {
			manager.persist(u);
		}
		manager.getTransaction().commit();
		manager.close();
	}
}
