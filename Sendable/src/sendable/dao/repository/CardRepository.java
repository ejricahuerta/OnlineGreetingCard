package sendable.dao.repository;

import java.util.ArrayList;

import data.mock.MockService;
import sendable.dao.entities.Card;

public class CardRepository implements RepositoryInterface<Card> {

	
	private MockService mockdata = null; //Database
	
	public CardRepository() { 
		mockdata = new MockService();
	}
	
	@Override
	public ArrayList<Card> ListAll() {
		return (ArrayList<Card>)this.mockdata.AllCards();
	}

	@Override
	public Card Get(int id) {
		return mockdata.AllCards().get(id);
	}

	@Override
	public void Insert(Card obj) {
		try {
			mockdata.AllCards().add(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Remove(int id) {
		try {
			mockdata.AllCards().remove(id);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Card Find(String query) {
		
		for (Card card : mockdata.AllCards()) {
			if(card.getDescription().contains(query)) {
				return card;
			}
		}
		return null;
	}
}
