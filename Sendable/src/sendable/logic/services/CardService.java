package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import sendable.dao.entities.Card;
import sendable.dao.entities.Category;
import sendable.dao.repository.*;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;
import sendable.logic.interfaces.CardInterface;

public class CardService implements CardInterface {

	private UnitOfWork unit;
	
	private List<CardDto> AllCards = new ArrayList<CardDto>();
	private List<CategoryDto> AllCategory = new ArrayList<CategoryDto>();

	CardDto card = null;

	public CardService(UnitOfWork work) {
		unit = work;
	}

	@Override
	public List<CardDto> ListCards() {
		if(AllCards.isEmpty()) {
			 for (Card c : unit.GetCardRepo().ListAll()) {
				AllCards.add(this.MapCard(c));
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
		if(AllCategory.isEmpty()) {
			for (Category c : unit.GetCategoryRepo().ListAll()) {
				AllCategory.add(this.MapCategory(c));
			}
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
			return new CategoryDto(category.getId(), category.getName(), category.getDescription(),
					category.getDateAdded());
		}
	}

	private CardDto MapCard(Card card) {
		if (card == null) {
			return null;
		}
		return new CardDto(card.getId(), card.getName(), card.getDescription(), card.getPrice(), card.isAvailable(),
				card.getDateAdded());
	}

	
	
//	public static void main(String[] args) {
//		SeedDatabase seed = new SeedDatabase();
//		
//		
//		EntityManager manager =  DatabaseManager.getEntityManager();
//		manager.getTransaction().begin();
//		
//		for (Card c : seed.AddCards()) {
//			manager.persist(c);
//		} 
//		manager.getTransaction().commit();
//		manager.close();
//		
//		CardService cardService = new CardService(new Repository<Card>(Card.class), new Repository<Category>(Category.class));
//		
//		System.out.println( cardService.getCard(1).getDateAdded());
//		System.out.println("End of Test");
//		
//	}
}
