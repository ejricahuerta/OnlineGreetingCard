package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import data.mock.SeedDatabase;
import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.interfaces.UnitOfWorkInterface;
import sendable.dao.repository.*;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;
import sendable.logic.interfaces.CardInterface;
import sendable.logic.mapper.SendableMapper;

public class CardService implements CardInterface {

	private UnitOfWorkInterface unit;

	private List<CardDto> AllCards = new ArrayList<CardDto>();
	private List<CategoryDto> AllCategory = new ArrayList<CategoryDto>();

	CardDto card = null;

	public CardService(UnitOfWorkInterface uow) {
		unit = uow;
		if(unit.GetCategoryRepo().ListAll().isEmpty()) {
			SeedDatabase seed = new SeedDatabase(unit);
		}
	}

	@Override
	public List<CardDto> ListCards() {
		if (AllCards.isEmpty()) {
			for (Card c : unit.GetCardRepo().ListAll()) {
				AllCards.add(SendableMapper.mapCardDto(c));
			}
		}
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

		if (AllCategory.isEmpty()) {
			for (Category c : unit.GetCategoryRepo().ListAll()) {
				AllCategory.add(this.MapCategory(c));
			}
			unit.Close();
		}

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
			CategoryDto tmp = new CategoryDto(category.getId(), category.getName(), category.getDescription(),
					category.getDateAdded());
			List<CardDto> cardtmp = new ArrayList<CardDto>();
			for (Card card : unit.GetCardRepo().ListAll()) {
				if (card.getCategory().getId() == category.getId()) {
					cardtmp.add(SendableMapper.mapCardDto(card));
				}
			}
			tmp.setCards(cardtmp);
			return tmp;
		}
	}

	

}
