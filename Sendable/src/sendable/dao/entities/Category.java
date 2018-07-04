package sendable.dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	String Name;
	String Description;
	String DateAdded;

	@OneToMany
	List<Card> Cards = new ArrayList<Card>();

	public Category() {
	}

	public Category(String name, String description, String dateAdded) {
		Name = name;
		Description = description;
		DateAdded = dateAdded;
	}

	public Category(String name, String description) {
		Name = name;
		Description = description;
		DateAdded = DateTime.GetCurrentDate();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getDateAdded() {
		return this.DateAdded;
	}

	public List<Card> getCards() {
		return Cards;
	}

	public void setCards(List<Card> cards) {
		Cards = cards;
	}

}
