/**
 * 
 */
package data.mock;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.*;

public class MockService {

	private List<User> SampleUsers = null;
	private List<Card> cards = null;

	public MockService() {

		SampleUsers = new ArrayList<User>();

		User user1 = new User("abc@111.com", "password1");
		User user2 = new User("abc@112.com", "password2");
		User user3 = new User("abc@113.com", "password3");
		User user4 = new User("abc@114.com", "password4");
		User user5 = new User("abc@115.com", "password5");

		SampleUsers.add(user1);
		SampleUsers.add(user2);
		SampleUsers.add(user3);
		SampleUsers.add(user4);
		SampleUsers.add(user5);

		// Cards Sample
		cards = new ArrayList<Card>();
		//cards.add(new Card(1, 0, "Birthday 1", "Sample card for birthday 1", 5, "bday1.jpeg", true));
		//cards.add(new Card(2, 0, "Birthday 2", "Sample card for birthday 2", 5, "bday2.jpeg", true));
	}

	public List<User> AllUsers() {
		return this.SampleUsers;
	}

	public List<Card> AllCards() {
		return this.cards;
	}
	
}
