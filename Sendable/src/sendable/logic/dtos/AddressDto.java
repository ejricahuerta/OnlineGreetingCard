package sendable.logic.dtos;

public class AddressDto {

	int Id;
	String Line1;
	String Line2;
	String City;
	String State;
	String PostalCode;

	public AddressDto(int id, String line1, String line2, String city, String state, String postalCode) {
		super();
		Id = id;
		Line1 = line1;
		Line2 = line2;
		City = city;
		State = state;
		PostalCode = postalCode;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLine1() {
		return Line1;
	}

	public void setLine1(String line1) {
		Line1 = line1;
	}

	public String getLine2() {
		return Line2;
	}

	public void setLine2(String line2) {
		Line2 = line2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

}
