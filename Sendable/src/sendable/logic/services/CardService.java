package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Card;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.CardDto;
import sendable.logic.interfaces.CardInterface;

public class CardService implements CardInterface {

	private RepositoryInterface<Card> repository = null; //TODO change to database
	private List<CardDto> AllCards = null;
	CardDto  card = null;

	public CardService(RepositoryInterface<Card> cardRepo) { 
		this.repository = cardRepo;
	}

	@Override
	public List<CardDto> ListCards() {
		ArrayList<CardDto> cardret = new ArrayList<CardDto>();
		for (Card card : repository.ListAll()) {

			cardret.add(new CardDto(card.getId(), card.getName(), card.getDescription(), card.getPrice(),
					card.isAvailable(), card.getDateAdded()));
		}
		AllCards = cardret;
		return cardret;
	}

	@Override
	public List<CardDto> ListCards(String filter) {
		System.out.println("Not Implemented");
		return null;
	}

	@Override
	public CardDto getCard(int id) {
		card = null;
		AllCards.forEach(c -> 
		{
			if (c.getId() == id) {
				card = c;
				return;
				
			}
		});
		return card;
	}
}
