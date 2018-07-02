package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;
import sendable.logic.interfaces.CardInterface;

public class CardService implements CardInterface {

	private RepositoryInterface<Card> cardRepository;
	private RepositoryInterface<Category> categoryRepository;
	private List<CardDto> AllCards = null;
	CardDto card = null;

	public CardService(RepositoryInterface<Card> cardRepo) {
		this.cardRepository = cardRepo;
	}

	public CardService(RepositoryInterface<Card> cardRepo, RepositoryInterface<Category> categoryRepo) {
		this.cardRepository = cardRepo;
		this.categoryRepository = categoryRepo;
	}

	@Override
	public List<CardDto> ListCards() {
		ArrayList<CardDto> cardret = new ArrayList<CardDto>();
		for (Card card : cardRepository.ListAll()) {

			cardret.add(new CardDto(card.getId(), card.getName(), card.getDescription(), card.getPrice(),
					card.isAvailable(), card.getDateAdded()));
		}
		AllCards = cardret;
		return cardret;
	}

	@Override
	public CardDto getCard(int id) {
		card = null;
		AllCards.forEach(c -> {
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
		ArrayList<CardDto> ret = new ArrayList<CardDto>();
		AllCards.forEach(c -> {
			if (c.getCategoryDto().getId() == categoryId) {
				ret.add(c);
			}
		});
		return ret;
	}

	@Override
	public List<CategoryDto> ListCategories() {
		ArrayList<CategoryDto> ret = new ArrayList<CategoryDto>();
		for (Category c : categoryRepository.ListAll()) {
			CategoryDto catret = new CategoryDto(c.getId(), c.getName(), c.getDescription(), c.getDateAdded());
			catret.setCards(ListCardsByCategory(c.getId()));
			ret.add(catret);
		}
		return ret;
	}

	@Override
	public List<CategoryDto> ListCategoriesByCardCount() {
		List<CategoryDto> ret = this.ListCategories();
		ret.sort((a, b) -> (a.getCards().size() > b.getCards().size()) ? 1 : 0);
		return ret;
	}

	@Override
	public CategoryDto GetCategory(int categoryId) {
		for (CategoryDto category : this.ListCategories()) {
			if (category.getId() == categoryId) {
				return category;
			}
		}
		return null;
	}

	@Override
	public CategoryDto GetCategoryByCard(int cardId) {
		return this.getCard(cardId).getCategoryDto();
	}
}
