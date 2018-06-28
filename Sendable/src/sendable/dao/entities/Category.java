package sendable.dao.entities;


/**
 * @author exd
 *
 */
public class Category extends BaseEntity{

	String Name;
	String Description;
	String DateAdded;

	public Category() {
		super(0);
		this.DateAdded = DateTime.GetCurrentDate();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param cards
	 * @param dateAdded
	 */
	
	
	public Category(int id, String name, String description, String dateAdded) {
		super(id);
		Name = name;
		Description = description;
		DateAdded = dateAdded;
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Category(int id, String name, String description) {
		super(id);
		Name = name;
		Description = description;
		DateAdded = DateTime.GetCurrentDate();
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
}
