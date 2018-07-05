package sendable.logic.dtos;

import java.util.List;

public class CategoryDto {

	int Id;
	String Name;
	String Description;
	String DateAdded;
	List<CardDto> Cards;
	int CardCount= 0;

	public CategoryDto(int id, String name, String description, String dateAdded) {
		super();
		Id = id;
		
		Name = name;
		Description = description;
		DateAdded = dateAdded;
		
	}

	public int getCardCount() {
		return CardCount;
	}

	public void setCardCount(int cardCount) {
		CardCount = cardCount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public List<CardDto> getCards() {
		return Cards;
	}

	public void setCards(List<CardDto> cards) {
		this.CardCount = cards.size();
		Cards = cards;
	}

}
