package sendable.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author exd
 *
 */
public class Category extends BaseEntity{

	String Name;
	String Description;
	List<Card> Cards;
	String DateAdded;

	public Category() {
		super(0);
		this.DateAdded = DateTime.GetCurrentDate();
		Cards = new ArrayList<Card>();
	}


	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param dateAdded
	 */
	public Category(int id, String name, String description, String dateAdded) {
		super(id);
		Name = name;
		Description = description;
		DateAdded = dateAdded;
		Cards = new ArrayList<Card>();
	}


	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param cards
	 * @param dateAdded
	 */
	public Category(int id, String name, String description, List<Card> cards, String dateAdded) {
		super(id);
		Name = name;
		Description = description;
		Cards = cards;
		DateAdded = dateAdded;
	}


	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public List<Card> getCards() {
		return this.Cards;
	}

	public void AddCard(Card card) {
		this.Cards.add(card);
	}
	
	public void AddCards(List<Card> card) {
		
	}

}
