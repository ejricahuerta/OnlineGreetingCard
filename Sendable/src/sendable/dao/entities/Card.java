package sendable.dao.entities;

public class Card extends BaseEntity {

	String Name;
	String Description;
	double Price;
	String ImageURL;
	boolean Available;
	String DateAdded;

	public Card() {
		super(0);
		this.Price = 0.0;
		this.DateAdded = DateTime.GetCurrentDate();
	}


	public Card(int id, String name, String description, double price, String imageURL, boolean available) {
		super(id);
		Name = name;
		Description = description;
		Price = price;
		ImageURL = imageURL;
		Available = available;
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

}
