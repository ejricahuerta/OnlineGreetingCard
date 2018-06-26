/**
 * 
 */
package data.mock;

import java.util.ArrayList;
import java.util.List;

import sendable.entities.*;

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
		cards.add(new Card("Birthday 1", "Sample card for birthday 1", 5));
		cards.add(new Card("Birthday 2", "Sample card for birthday 2", 5));

		for (User user : SampleUsers) {
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
		}

	}

	public List<User> AllUsers() {

		return SampleUsers;

	}

	public boolean AddUser(User newUser) 
	{

		if (newUser != null) {
			SampleUsers.add(newUser);
			System.out.println("New User: " + newUser.getEmail());
			return true;
		} else {
			System.out.println("Empty User");
			return false;
		}
	}

	public List<Card> AllCards() {
		return this.cards;
	}
	
}
