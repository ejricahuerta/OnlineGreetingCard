package sendable.dao.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
@Table
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	String Name;
	String Description;
	double Price;
	String ImageURL;
	boolean Available;
	String DateAdded;

	@ManyToOne
	Category Category;

	public Card() {
		this.DateAdded = DateTime.GetCurrentDate();
	}

	public Card(Category category, String name, String description, double price, String imageURL, boolean available) {
		Category = category;
		Name = name;
		Description = description;
		Price = price;
		ImageURL = imageURL;
		Available = available;
		DateAdded = DateTime.GetCurrentDate();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return this.Description;
	}

	public String getName() {
		return this.Name;
	}

	public double getPrice() {
		return this.Price;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public void setAvailable(boolean isTrue) {
		this.Available = isTrue;
	}

	public boolean isAvailable() {
		return Available;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setPrice(double price) {
		Price = price;
	}
}
