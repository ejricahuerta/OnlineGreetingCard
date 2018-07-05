package sendable.dao.database;

import java.util.ArrayList;
import java.util.List;

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
			AllCards.add(new Card(AllCategories.get(1), "Birthday 1", null, 0, null, Seeded));
			AllCards.add(new Card(AllCategories.get(1), "Birthday 2", null, 0, null, Seeded));
			AllCards.add(new Card(AllCategories.get(1), "Birthday 2", null, 0, null, Seeded));
			AllCards.add(new Card(AllCategories.get(1), "Birthday 2", null, 0, null, Seeded));
			AllCards.add(new Card(AllCategories.get(1), "Birthday 2", null, 0, null, Seeded));
		}
		return AllCards;

	}

	public List<Category> AddCategories() {
		if (AllCategories.isEmpty()) {
			
			this.AllCategories.add(new Category("Birthdays", "All Birthday Greetings"));

			this.AllCategories.add(new Category("Aniversaries", "All Aniversary Greetings"));

			this.AllCategories.add(new Category("Parents", "All Parents Ocassion Greetings"));

			this.AllCategories.add(new Category("Valentines", "All Love is in the Air"));

			this.AllCategories.add(new Category("Congratulation", "Send Congratulations"));
		}
		return this.AllCategories;
	}

	public boolean IsSeeded() {
		return this.Seeded;
	}
}
