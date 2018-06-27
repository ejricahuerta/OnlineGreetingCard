package sendable.dao.entities;

public class Address extends BaseEntity {

	String Line1;
	String Line2;
	String City;
	String State;
	String PostalCode;

	public Address() {
		super(0);
	}

	public Address(String line1, 
			String line2, 
			String city, 
			String state, 
			String postalcode) {
		super(0);
		this.Line1 = line1;
		this.Line2 = line2;
		this.City = city;
		this.State = state;
		this.PostalCode = postalcode;
	}

	public String getLine1() {
		return this.Line1;
	}

	public String getLine2() {
		return this.Line2;
	}

	public String getCity() {
		return this.City;
	}

	public String getState() {
		return this.State;
	}
	
	public String getPostalCode() {
		return this.PostalCode;
	}
}
