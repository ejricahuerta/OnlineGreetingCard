package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CategoryDto;

public interface CardInterface {

	List<CardDto> ListCards();
	
	List<CardDto> ListCardsByquery(String query);
	
	List<CardDto> ListCardsByCategory(int categoryId);
	
	List<CategoryDto> ListCategories();

	List<CategoryDto> ListCategoriesByCardCount();
	
	CategoryDto GetCategory(int categoryId);
	
	CategoryDto GetCategoryByCard(int cardId);
	
	CardDto getCard(int id);
	
}
