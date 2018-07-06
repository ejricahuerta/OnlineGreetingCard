package sendable.logic.dtos;

public class CardDto {

	int Id;
	int CategoryId;
	String Name;
	String Description;
	String ImageURL;
	double Price;
	boolean Available;
	String DateAdded;

	public CardDto(int id, String name, String description, String image, double price, boolean available, String dateAdded) {
		super();
		Id = id;
		Name = name;
		Description = description;
		Price = price;
		Available = available;
		DateAdded = dateAdded;
		ImageURL = image;
	}

	public CardDto() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int CategoryId) {
		this.CategoryId = CategoryId;
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

	
	
	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}
}
