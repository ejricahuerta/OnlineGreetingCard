package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Card;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;
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

	@Override
	public List<CardDto> ListCardsByquery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardDto> ListCardsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> ListCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> ListCategoriesByCardCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto GetCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto GetCategoryByCard(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}
}
