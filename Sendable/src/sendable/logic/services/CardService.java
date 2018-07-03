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
	private List<CategoryDto> AllCategory = null;

	CardDto card = null;

	public CardService(RepositoryInterface<Card> cardRepo) {
		this.cardRepository = cardRepo;
	}

	public CardService(RepositoryInterface<Card> cardRepo, RepositoryInterface<Category> categoryRepo) {
		this.cardRepository = cardRepo;
		this.categoryRepository = categoryRepo;

		for (Category category : this.categoryRepository.ListAll()) {
			AllCategory.add(this.MapCategory(category));
		}
		for (Card card : this.cardRepository.ListAll()) {
			AllCards.add(this.MapCard(card));
		}
	}

	@Override
	public List<CardDto> ListCards() {
		return this.AllCards;
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
			if (c.getCategoryId() == categoryId) {
				ret.add(c);
			}
		});
		return ret;
	}

	@Override
	public List<CategoryDto> ListCategories() {
		return this.AllCategory;
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
		for (CardDto cardDto : AllCards) {
			if (cardDto.getId() == cardId) {
				for (CategoryDto category : this.AllCategory) {
					if (category.getId() == cardDto.getCategoryId()) {
						return category;
					}
				}
			}
		}
		return null;
	}

	private CategoryDto MapCategory(Category category) {
		if (category == null) {
			return null;
		} else {
			return new CategoryDto(category.getId(), category.getName(), category.getDescription(),
					category.getDateAdded());
		}
	}

	private CardDto MapCard(Card card) {
		if(card == null) {
			return null;
		}
		return new CardDto(card.getId(), card.getName(), card.getDescription(), card.getPrice(), card.isAvailable(),
				card.getDateAdded());
	}
}
